package com.company.programs;

public class CoinChange {
  public static int minCoins(int[] coins, int amount) {

    int [][]dp = new int[coins.length][amount + 1];
    for(int i=0; i<coins.length; i++) {
      for(int j=0; j<=amount; j++) {
        dp[i][j] = -1;
      }
    }

    dp[0][0] = 0;

    for(int i=0; i<coins.length; i++) {

      for(int j=0; j<=amount; j++) {

        if(i > 0 && j-coins[i] >= 0 && dp[i-1][j-coins[i]] != -1) {
          dp[i][j] = 1 + dp[i-1][j-coins[i]];
        }
        if(j-coins[i] >= 0 && dp[i][j-coins[i]] != -1) {
          if(dp[i][j] != -1)
           dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j-coins[i]]);
          else
            dp[i][j] = 1 + dp[i][j-coins[i]];
        }
        if(i > 0 && dp[i-1][j] != -1) {
          if(dp[i][j] != -1)
            dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
          else
            dp[i][j] = dp[i-1][j];
        }
      }
    }
    return dp[coins.length - 1][amount];
  }
}
