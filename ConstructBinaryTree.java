package com.company.programs;

public class ConstructBinaryTree {

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return constructTree(0, inorder.length-1, 0, preorder.length-1, preorder, inorder );
  }

  private TreeNode constructTree(int inorderL, int inorderR, int preorderL, int preorderR, int[] preorder, int[] inorder) {

    if( inorderL > inorderR || preorderL > preorderR) return null;

    if(inorderL == inorderR) {
      return new TreeNode(inorder[inorderL]);
    } else if( preorderL == preorderR) {
      return new TreeNode(preorder[preorderL]);
    } else {
      int val = preorder[preorderL];
      TreeNode node = new TreeNode(val);
      int mid = 0;
      for(int i = inorderL; i <= inorderR; i++) {
        if(inorder[i] == val) {
          mid = i;
          break;
        }
      }

      int leftSize = mid - inorderL;
      int rightSize = inorderR - mid;
      node.left = constructTree(inorderL, mid-1, preorderL + 1, preorderL + leftSize, preorder, inorder );
      node.right = constructTree(mid+1, inorderR, preorderL + leftSize + 1, preorderL + leftSize + rightSize, preorder, inorder );

      return node;
    }
  }
}
