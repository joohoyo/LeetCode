package joohoyo.leetcode.challenge.july;

// Plus One
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/
// 16:01 ~ 16:11 (10mins)

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlusOne {
    @Test
    public void test() {
        PlusOne.Solution s = new PlusOne.Solution();

        assertArrayEquals(new int[]{1}, s.plusOne(new int[]{0}));
        assertArrayEquals(new int[]{1, 0}, s.plusOne(new int[]{9}));
        assertArrayEquals(new int[]{1, 2, 4}, s.plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, s.plusOne(new int[]{4, 3, 2, 1}));
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            String str = "";
            for (int i = 0; i < digits.length; i++) {
                str += digits[i];
            }

            BigInteger bi = new BigInteger(str).add(BigInteger.ONE);

            String resultStr = bi.toString();
            int[] result = new int[resultStr.length()];
            for (int i = 0; i < resultStr.length(); i++) {
                result[i] = resultStr.charAt(i) - '0';
            }
            return result;
        }
    }
}
