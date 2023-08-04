package com.company.programs;

public class MedianFinder {

  int []heap = new int[50001];
  int heap_size = 0;
  public MedianFinder() {
    heap[0] = Integer.MIN_VALUE;
  }

  public void addNum(int num) {
    heap_size++;
    heap[heap_size] = num;
    heapify(heap_size);
  }

  void heapify(int i) {

    while(i > 0) {
      if(heap[i/2] > heap[i]) {
        int tmp = heap[i/2];
        heap[i/2]  = heap[i];
        heap[i] = tmp;
        i = i/2;
      } else {
        break;
      }
    }
  }

  public double findMedian() {
    if(heap_size % 2 == 0) {
      int mid1 = heap_size/2;
      int mid2= mid1 + 1;

      return (heap[mid1] + heap[mid2]) / 2.0;
    } else {
      int mid = heap_size/2 + 1;
      return (heap[mid]);
    }
  }

}
