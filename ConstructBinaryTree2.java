package com.company.programs;

public class ConstructBinaryTree2 {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return constructTree(0, inorder.length-1, 0, postorder.length-1, inorder, postorder );
  }

  private TreeNode constructTree(int inorderL, int inorderR, int postorderL, int postorderR, int[] inorder, int[] postorder) {

    if( inorderL > inorderR || postorderL > postorderR) return null;

    if(inorderL == inorderR) {
      return new TreeNode(inorder[inorderL]);
    } else if( postorderL == postorderR) {
      return new TreeNode(postorder[postorderL]);
    } else {
      int val = postorder[postorderR];
      TreeNode node = new TreeNode(val);
      int mid = 0;
      for(int i = inorderL; i <= inorderR; i++) {
        if(inorder[i] == val) {
          mid = i;
          break;
        }
      }

      int leftSize = mid - inorderL;
      node.left = constructTree(inorderL, mid-1, postorderL, postorderL + leftSize -1, inorder, postorder );
      node.right = constructTree(mid+1, inorderR, postorderL + leftSize, postorderR -1, inorder, postorder);

      return node;
    }
  }

}
