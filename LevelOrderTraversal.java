package com.company.programs;

import java.util.*;

public class LevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> deque = new ArrayDeque<>();

    if( root  == null ) return result;

    deque.add(new AbstractMap.SimpleEntry<>(root, 0));

    while(!deque.isEmpty()) {

      AbstractMap.SimpleEntry<TreeNode, Integer> element = deque.poll();

      if(element.getValue() < result.size()) {
        result.get(element.getValue()).add(element.getKey().val);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(element.getKey().val);
        result.add(list);
      }

      if( element.getKey().left != null )
        deque.add(new AbstractMap.SimpleEntry<>(element.getKey().left, element.getValue() + 1));

      if( element.getKey().right != null )
        deque.add(new AbstractMap.SimpleEntry<>(element.getKey().right, element.getValue() + 1));
    }

    return result;
  }

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
}
