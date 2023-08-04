package com.company.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestBST {

  public int kthSmallest(TreeNode root, int k) {

    Stack<TreeNode> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();

    TreeNode itr = root;
    while(itr != null) {
      stack.push(itr);
      itr = itr.left;
    }

    while(!stack.isEmpty()) {
      TreeNode current = stack.pop();
      result.add(current.val);
      if(current.right != null) {
        itr = current.right;
        while(itr != null) {
          stack.push(itr);
          itr = itr.left;
        }
      }
    }
    return result.get(k);
  }


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
