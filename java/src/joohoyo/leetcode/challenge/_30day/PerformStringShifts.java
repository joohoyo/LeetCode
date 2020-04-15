package joohoyo.leetcode.challenge._30day;

// Perform String Shifts
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
// 18:22 ~ 18:34 (12min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerformStringShifts {
    @Test
    public void test() {
        PerformStringShifts.Solution s = new PerformStringShifts.Solution();

        Assertions.assertEquals("cab", s.stringShift("abc", new int[][]{{0, 1}, {1, 2}}));
        Assertions.assertEquals("bca", s.stringShift("abc", new int[][]{{0, 1}}));
        Assertions.assertEquals("efgabcd", s.stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}}));
        Assertions.assertEquals("yisxjwry", s.stringShift("yisxjwry", new int[][]{{1, 8}, {1, 4}, {1, 3}, {1, 6}, {0, 6}, {1, 4}, {0, 2}, {0, 1}}));
    }

    class Solution {
        public String stringShift(String s, int[][] shift) {
            int totalAmount = 0;
            for (int i = 0; i < shift.length; i++) {
                totalAmount += shift[i][0] == 0 ? -shift[i][1] : shift[i][1];
            }
            totalAmount = totalAmount % s.length();

            if (totalAmount > 0) {
                int index = s.length() - totalAmount;
                return s.substring(index) + s.substring(0, index);
            } else if (totalAmount < 0) {
                return s.substring(0 - totalAmount) + s.substring(0, 0 - totalAmount);
            }
            return s;
        }
    }
}
