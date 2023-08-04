package com.company.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InsertInterval {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    int left = -1, right = -1;
    int i, j;
    ArrayList<int[]> result = new ArrayList<>();
    if(intervals.length == 0) {
      result.add(newInterval);
    }
    else if (newInterval[1] < intervals[0][0]) {
      result.add(newInterval);
      Collections.addAll(result, intervals);
    } else if (newInterval[0] > intervals[intervals.length - 1][1]) {
      Collections.addAll(result, intervals);
      result.add(newInterval);
    } else {
      for (i = 0; i < intervals.length; i++) {
        if (newInterval[0] < intervals[i][0]) {
          left = newInterval[0];
          break;
        }
        else if(newInterval[0] <= intervals[i][1]) {
          left = intervals[i][0];
          break;
        }
        else {
          result.add(intervals[i]);
        }
      }

      for (j = i; j < intervals.length; j++) {
        if (newInterval[1] < intervals[j][0]) {
          right = j;
          result.add(new int[]{left, newInterval[1]});
          break;
        }
        else if (newInterval[1] <= intervals[j][1]) {
          right = j+1;
          result.add(new int[]{left, intervals[j][1]});
          break;
        }
      }

      if( right == -1) {
        result.add(new int[]{left, newInterval[1]});
      } else {
        for(int k=right; k<intervals.length; k++) {
          result.add(intervals[k]);
        }
      }
    }
    int arr[][] = new int[0][];
    return result.toArray(arr);
  }
}
