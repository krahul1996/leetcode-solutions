package com.company.programs;

public class MaximumStockProfit {
    public static int maxProfit(int[] prices) {
        int buys[] = new int[prices.length];
        int sells[] = new int[prices.length];

        buys[0] = -prices[0];
        sells[0] = 0;

        for(int i = 1; i < prices.length; i++) {
            buys[i] = sells[i] = -100001;
            for(int j = 0; j < i; j++ ) {
                buys[i] = Integer.max(buys[i], -prices[i] + sells[j] );
                sells[i] = Integer.max(sells[i], prices[i] + buys[j] );
            }
        }
        int maxProfit = 0;
        for(int i = 0; i< sells.length; i++) {
            maxProfit = Integer.max(maxProfit, sells[i]);
        }
        return maxProfit;
    }
}
