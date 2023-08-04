package com.company.programs;

public class HouseRobber2 {
  public int rob(int[] nums) {

    int len = nums.length;

    if(nums.length == 1) return nums[0];
    else if(nums.length == 2) return Math.max(nums[0], nums[1]);

    int dp[][] = new int[nums.length][2];

    dp[0][0] = nums[0];
    dp[0][1] = 0;
    dp[1][0] = nums[1];
    dp[1][1] = nums[0];

    for(int i=2; i<len-1; i++) {
      dp[i][0] = nums[i] + Math.max(dp[i-1][1], Math.max(dp[i-2][0], dp[i-2][1]));
      dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
    }
    int result = Math.max(dp[len-2][0], dp[len-2][1]);

    dp[1][0] = nums[1];
    dp[1][1] = 0;
    dp[2][0] = nums[2];
    dp[2][1] = nums[1];

    for(int i=3; i<len; i++) {
      dp[i][0] = nums[i] + Math.max(dp[i-1][1], Math.max(dp[i-2][0], dp[i-2][1]));
      dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
    }
    int result1 = Math.max(dp[len-1][0], dp[len-1][1]);

    return Math.max(result, result1);

  }
}
