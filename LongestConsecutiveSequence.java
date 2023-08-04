package com.company.programs;

import java.util.HashMap;

public class LongestConsecutiveSequence {

  public int longestConsecutive(int[] nums) {

    HashMap<Integer, Boolean> hmp = new HashMap<>();
    int result = 0;
    for(int i=0; i<nums.length; i++) {
      hmp.put(nums[i], true);
    }

    for(int i=0; i<nums.length; i++) {
      int count = 0;
      if(hmp.containsKey(nums[i])) {

        int j = nums[i];
        while(hmp.containsKey(j)) {
          hmp.remove(j);
          count += 1;
          j--;
        }

        int k = nums[i] + 1;
        while(hmp.containsKey(k)) {
          hmp.remove(k);
          count += 1;
          k++;
        }
        result = Math.max(result, count);
      }
    }
    return result;
  }

}
