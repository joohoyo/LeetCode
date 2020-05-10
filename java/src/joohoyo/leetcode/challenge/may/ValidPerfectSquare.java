package joohoyo.leetcode.challenge.may;

// Valid Perfect Square
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
// 11:08 ~ gg (min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidPerfectSquare {
    @Test
    public void test() {
        ValidPerfectSquare.Solution s = new ValidPerfectSquare.Solution();

        assertEquals(true, s.isPerfectSquare(808201));
        assertEquals(false, s.isPerfectSquare(14));
        assertEquals(true, s.isPerfectSquare(1));
        assertEquals(true, s.isPerfectSquare(16));
        assertEquals(true, s.isPerfectSquare(9));
        assertEquals(false, s.isPerfectSquare(2147483647));
        assertEquals(false, s.isPerfectSquare(2147483646));
    }

    class Solution {
        public boolean isPerfectSquare(int num) {
            double x = 2;

            for (int i = 0; i < 100; i++) {
                x = (x + (num / x)) / 2;
            }

            return x == (int) x;
        }
    }
}
