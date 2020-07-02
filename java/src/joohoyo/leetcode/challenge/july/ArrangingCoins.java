package joohoyo.leetcode.challenge.july;

// Arranging Coins
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
// 12:47 ~ 12:52 (5mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrangingCoins {
    @Test
    public void test() {
        ArrangingCoins.Solution s = new ArrangingCoins.Solution();

        assertEquals(2, s.arrangeCoins(5));
        assertEquals(3, s.arrangeCoins(8));
        assertEquals(3, s.arrangeCoins(6));
    }

    class Solution {
        public int arrangeCoins(int n) {
            int c = n;
            int s = 1;
            while (c >= 0 && c >= s) {
                c -= s;
                s++;
            }
            return s - 1;

        }
    }
}
