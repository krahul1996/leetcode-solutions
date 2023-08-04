package com.company.programs;

public class NumberOf1Bits {
  // you need to treat n as an unsigned value
  public static int hammingWeight(int n) {
    int count = 0;
    while(n != 0) {
      if((n & 1) > 0) {
        count++;
      }
      n = n >>> 1;
    }
    return count;
  }
}
