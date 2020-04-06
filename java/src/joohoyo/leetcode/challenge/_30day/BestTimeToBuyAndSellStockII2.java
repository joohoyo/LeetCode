package joohoyo.leetcode.challenge._30day;

// Best Time to Buy and Sell Stock II
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3287/
// 14:30 ~ 14:51 (21min)
// 하아.. 솔루션 보면 간단하네.. 

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockII2 {
    @Test
    public void test() {
        BestTimeToBuyAndSellStockII2.Solution s = new BestTimeToBuyAndSellStockII2.Solution();

        assertEquals(7, s.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
        assertEquals(4, s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(7, s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(6, s.maxProfit(new int[]{1, 7, 4, 2}));
        assertEquals(7, s.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
        assertEquals(0, s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            int[] profits = new int[n];
            for (int i = 1; i < n; i++) {
                int max = profits[i - 1];
                for (int j = 0; j < i; j++) {
                    int profit = prices[i] - prices[j];
                    if (profits[j] + profit > max) {
                        max = profits[j] + profit;
                    }
                }
                profits[i] = max;
            }
            return profits[n - 1];
        }
    }
}
