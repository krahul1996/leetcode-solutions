package com.company.programs;

public class HouseRobber {
  public int rob(int[] nums) {

    if(nums.length == 0) return 0;
    else if(nums.length == 1) return nums[0];
    else if(nums.length == 2) return Math.max(nums[0], nums[1]);

    int [][]dp = new int[nums.length][2];

    dp[0][0] = nums[0];
    dp[0][1] = 0;
    dp[1][0] = nums[1];
    dp[1][1] = nums[0];

    for(int i=2; i<nums.length; i++) {
      dp[i][0] = nums[i] + Math.max(dp[i-1][1], Math.max(dp[i-2][0], dp[i-2][1]));
      dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
    }

    return Math.max(dp[nums.length-1][0], dp[nums.length-1][1] );
  }
}
