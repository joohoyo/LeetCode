package joohoyo.leetcode.challenge._30day;

// Best Time to Buy and Sell Stock II
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3287/
// 11:44 ~ gg (min)
// Time Limit Exceeded

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockII {
    @Test
    public void test() {
        BestTimeToBuyAndSellStockII.Solution s = new BestTimeToBuyAndSellStockII.Solution();

        assertEquals(7, s.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
        assertEquals(4, s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        assertEquals(7, s.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(6, s.maxProfit(new int[]{1, 7, 4, 2}));
        assertEquals(7, s.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
        assertEquals(0, s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    class Solution {
        int answer;

        public int maxProfit(int[] prices) {
            this.answer = 0;
            backtracking(prices, 0, 0);
            return this.answer;
        }

        private void backtracking(int[] prices, int start, int profit) {
            if (profit > this.answer) {
                this.answer = profit;
            }
            if (start > prices.length - 2) {
                return;
            }

            for (int i = start; i < prices.length - 1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] > prices[i]) {
                        profit += prices[j] - prices[i];
                        backtracking(prices, j + 1, profit);
                        profit -= prices[j] - prices[i];
                    }
                }
            }
            return;
        }
    }
}
