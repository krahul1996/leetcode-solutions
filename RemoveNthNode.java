package com.company.programs;

public class RemoveNthNode {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    int size = 0;

    //get size
    ListNode itr = head;
    while(itr != null) {
      size++;
      itr = itr.next;
    }
    int prev_index = size - n;

    if(prev_index == 0) {
      return head.next;
    } else {
      ListNode itr1 = head;
      int i = 1;
      while(i < prev_index)
        itr1 = itr1.next;
      itr1.next = itr1.next.next;
    }

    return head;

  }

  private class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
