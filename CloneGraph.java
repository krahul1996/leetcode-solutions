package com.company.programs;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {
  Node[] nodeRefs = new Node[101];
  public Node cloneGraph(Node node) {
    return cloneGraphHelper(node);
  }

  public Node cloneGraphHelper(Node node) {
    if(nodeRefs[node.val] == null) {
      nodeRefs[node.val] = new Node(node.val);
      for(Node nodeN: node.neighbors) {
        Node newN = cloneGraphHelper(nodeN);
        nodeRefs[node.val].neighbors.add(newN);
      }
    }
    return nodeRefs[node.val];
  }


  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
