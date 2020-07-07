package joohoyo.leetcode.challenge.july;

// Plus One
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/
// 16:01 ~ 16:11 (10mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlusOne2 {
    @Test
    public void test() {
        PlusOne2.Solution s = new PlusOne2.Solution();

        assertArrayEquals(new int[]{1}, s.plusOne(new int[]{0}));
        assertArrayEquals(new int[]{1, 0}, s.plusOne(new int[]{9}));
        assertArrayEquals(new int[]{1, 2, 4}, s.plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, s.plusOne(new int[]{4, 3, 2, 1}));
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }

            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    }
}
