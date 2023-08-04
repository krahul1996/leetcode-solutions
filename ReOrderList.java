package com.company.programs;

import java.awt.*;

public class ReOrderList {

  public void reorderList(ListNode head) {
    int size = 0;
    //get size
    ListNode itr = head;
    ListNode prev, curr, ptr1, ptr2, ritr;
    while(itr != null) {
      size++;
      itr = itr.next;
    }
    //reverse half list
    int rev_start = (size + 2) / 2;
    itr = head;
    for(int i = 1; i<rev_start; i++)
      itr = itr.next;

    prev = null;
    curr = itr;

    while(curr != null) {
      ptr1 = curr.next;
      curr.next = prev;
      prev = curr;
      curr = ptr1;
    }

    ritr = prev;
    itr = head;
    while(itr != null && ritr != null && itr.next != ritr) {
      ptr1 = itr.next;
      ptr2 = ritr.next;
      itr.next = ritr;
      ritr.next = ptr1;
      itr = ptr1;
      ritr = ptr2;
    }
  }


  private class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}





