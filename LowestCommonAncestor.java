package com.company.programs;

public class LowestCommonAncestor {

  public TreeNode LCA;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    TreeNode left = p.val < q.val ? p : q;
    TreeNode right = q.val > p.val ? q : p;
    return getLCA(root, left, right);
  }

  public TreeNode getLCA(TreeNode node, TreeNode p, TreeNode q) {

    if (node.val == p.val)
      return p;
    else if (node.val == q.val)
      return q;
    else if (p.val < node.val && node.val < q.val)
      return node;
    else if (p.val < node.val)
      return getLCA(node.left, p, q);
    else
      return getLCA(node.right, p, q);
  }

}
