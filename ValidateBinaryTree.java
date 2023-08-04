package com.company.programs;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
   }
}


public class ValidateBinaryTree {

    public boolean validateBinaryTree(TreeNode root) {
      return isValidSubtree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidSubtree(TreeNode node, Long leftLimit, Long rightLimit ) {

      if( !(leftLimit < node.val && node.val < rightLimit) )
        return false;

      if(node.left != null && node.right != null) {
        if( node.left.val >= node.val || node.right.val <= node.val )
          return false;
        return isValidSubtree(node.left, leftLimit, (long)node.val) && isValidSubtree(node.right, (long)node.val, rightLimit);
      }
      else if( node.left != null) {
        if( node.left.val >= node.val )
          return false;
        return isValidSubtree(node.left, leftLimit, (long)node.val);
      }
      else if( node.right != null ){
        if( node.right.val <= node.val)
          return false;
        return isValidSubtree(node.right, (long)node.val, rightLimit);
      }
      return true;
    }
}
