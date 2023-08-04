package com.company.programs;

public class Frog {

  public int getDistance(int [] arr) {

    int[] left = new int[arr.length];
    int [] right = new int[arr.length];

    int n = arr.length;

    for( int i=0; i<n; i++ ) {
      if( i == 0 )
        left[i] = 1;
      else if( arr[i] <= arr[i-1]) {
        left[i] = left[i-1] + 1;
      } else {
        left[i] = 1;
      }
    }

    for(int i = n-1; i>=0; i--) {
      if( i == n-1  )
        right[i] = 1;
      else if( arr[i] <= arr[i+1]) {
        right[i] = right[i+1] +1;
      } else {
        right[i] = 1;
      }
    }

    int res = Integer.MIN_VALUE;

    for(int i=0; i<n; i++) {
      res = Math.max(res, left[i] + right[i] -1 );
    }
    return res;
  }
}
