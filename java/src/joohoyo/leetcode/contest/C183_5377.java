package joohoyo.leetcode.contest;

// 5377. Number of Steps to Reduce a Number in Binary Representation to One
// https://leetcode.com/contest/weekly-contest-183/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
// 11:43 ~ 12:02 (19min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C183_5377 {
    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(6, s.numSteps("1101"));
        assertEquals(1, s.numSteps("10"));
        assertEquals(0, s.numSteps("1"));
    }

    class Solution {
        public int numSteps(String s) {
            int answer = 0;

            while (s.length() > 1) {
                if (s.substring(s.length() - 1, s.length()).equals("0")) {
                    s = divide(s);
                } else {
                    s = add1(s);
                }
                answer++;
            }

            return answer;
        }

        private String divide(String s) {
            return s.substring(0, s.length() - 1);
        }

        private String add1(String s) {
            for (int i = s.length() - 1; i > 0; i--) {
                String sub = s.substring(i, i + 1);
                if (sub.equals("0")) {
                    return s.substring(0, i) + "1" + s.substring(i + 1, s.length() - 1) + "0";
                }
            }
            return "1" + "0".repeat(s.length());
        }
    }
}
