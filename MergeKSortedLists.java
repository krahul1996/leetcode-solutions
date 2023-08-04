package com.company.programs;

import java.util.*;

public class MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    List<Integer> list = new ArrayList<>();

    for(int i=0; i<lists.length; i++) {
      ListNode node = lists[i];
      while(node != null) {
        list.add(node.val);
        node = node.next;
      }
    }
    Collections.sort(list);

    if(list.size() == 0) return null;

    ListNode result = new ListNode(list.get(0));
    ListNode previous = result;
    for(int i=1; i<list.size(); i++) {
      ListNode nextNode = new ListNode(list.get(i));
      previous.next = nextNode;
      previous = nextNode;
    }
    return result;
  }

  public ListNode mergeKListsPriorityQueue(ListNode[] lists) {

    if (lists==null||lists.length ==0) return null;

    Queue<ListNode> pq= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
      @Override
      public int compare(ListNode o1,ListNode o2){
        if (o1.val<o2.val)
          return -1;
        else if (o1.val==o2.val)
          return 0;
        else
          return 1;
      }
    });

    for(ListNode node: lists) {
      if( node != null)
        pq.add(node);
    }

    ListNode result = new ListNode(0);
    ListNode previous = result;

    while(!pq.isEmpty()) {

      ListNode top = pq.poll();
      previous.next = top;
      previous = top;

      if(top.next != null) {
        pq.add(top.next);
      }
    }
    return result.next;

  }



  public class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
