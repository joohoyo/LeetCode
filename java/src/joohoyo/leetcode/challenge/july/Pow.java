package joohoyo.leetcode.challenge.july;

// Pow(x, n)
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3392/
// 17:45 ~ gg (mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pow {
    @Test
    public void test() {
        Pow.Solution s = new Pow.Solution();

        assertEquals(Math.pow(3.0, 0), s.myPow(3.0, 0));
        assertEquals(Math.pow(3.0, 1), s.myPow(3.0, 1));
        assertEquals(Math.pow(3.0, 3), s.myPow(3.0, 3));
        assertEquals(Math.pow(3.0, 2), s.myPow(3.0, 2));
        assertEquals(Math.pow(3.0, 10), s.myPow(3.0, 10));
        assertEquals(Math.pow(2.1, 3), s.myPow(2.1, 3));
        assertEquals(Math.pow(1.0, 2147483647), s.myPow(1.0, 2147483647));
        assertEquals(Math.pow(2.0, -1), s.myPow(2.0, -1));
        assertEquals(Math.pow(2.0, -2), s.myPow(2.0, -2));
        assertEquals(Math.pow(2.0, -2), s.myPow(2.0, -2));
    }

    class Solution {
        private double pow(double x, long N) {
            if (N == 0) {
                return 1D;
            }

            double half = pow(x, N / 2);
            if (N % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        }

        public double myPow(double x, int n) {
            if (n == 0) {
                return 1D;
            }

            long N = n;
            if (N < 0) {
                N = -N;
                x = 1 / x;
            }

            return pow(x, N);
        }
    }
}
