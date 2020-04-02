package joohoyo.leetcode.problems.medium;

// 50. Pow(x, n)
// https://leetcode.com/problems/powx-n/
// 11:01 ~ gg (min)
// Time Limit Exceeded

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M50 {
    @Test
    public void test() {
        M50.Solution s = new M50.Solution();

        assertEquals(Math.pow(2.0, 0), s.myPow(2.0, 0));
        assertEquals(Math.pow(2.0, 1), s.myPow(2.0, 1));
        assertEquals(Math.pow(2.0, 10), s.myPow(2.0, 10));
        assertEquals(Math.pow(2.1, 3), s.myPow(2.1, 3));
        assertEquals(Math.pow(2.0, -1), s.myPow(2.0, -1));
        assertEquals(Math.pow(2.0, -2), s.myPow(2.0, -2));
    }

    class Solution {
        public double myPow(double x, int n) {
            double answer = 1D;

            if (n == 0) {
                return answer;
            } else if (n > 0) {
                for (int i = 0; i < n; i++) {
                    answer = answer * x;
                }
                return answer;
            } else {
                for (int i = 0; i > n; i--) {
                    answer = answer / x;
                }
                return answer;
            }
        }
    }
}
