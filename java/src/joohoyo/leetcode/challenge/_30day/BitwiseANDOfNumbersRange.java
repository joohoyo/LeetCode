package joohoyo.leetcode.challenge._30day;

// Bitwise AND of Numbers Range
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3308/
// 20:31 ~ gg (min)
// Time Limit Exceeded
// find common prefix 문제..라고 잘 생각하면 풀 수 있음.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitwiseANDOfNumbersRange {
    @Test
    public void test() {
        BitwiseANDOfNumbersRange.Solution s = new BitwiseANDOfNumbersRange.Solution();

        assertEquals(4, s.rangeBitwiseAnd(5, 7));
        assertEquals(4, s.rangeBitwiseAnd(4, 7));
        assertEquals(6, s.rangeBitwiseAnd(6, 7));
        assertEquals(0, s.rangeBitwiseAnd(4, 9));
        assertEquals(0, s.rangeBitwiseAnd(0, 1));
        assertEquals(1, s.rangeBitwiseAnd(1, 1));
        assertEquals(0, s.rangeBitwiseAnd(1, 2));
        assertEquals(0, s.rangeBitwiseAnd(1, 3));
        assertEquals(0, s.rangeBitwiseAnd(0, 2147483647));
    }

    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            if (m == 0) {
                return 0;
            }
            int moveFactor = 1;
            while (m != n) {
                m >>= 1;
                n >>= 1;
                moveFactor <<= 1;
            }
            return m * moveFactor;
        }
    }
//    class Solution {
//        private int MAX_BITS_COUNT = 32;
//
//        public int rangeBitwiseAnd(int m, int n) {
//            if (m == 0) {
//                return 0;
//            }
//            if (m == n) {
//                return n;
//            }
//
//            int[] bits = getBits();
//            int left = 0;
//            int right = 0;
//            for (left = 0; left < MAX_BITS_COUNT && bits[left] <= m; left++) {
//                if (m == bits[left]) {
//                    return m;
//                }
//            }
//            for (right = 0; right < MAX_BITS_COUNT && bits[right] <= n; right++) {
//                if (n == bits[right]) {
//                    return n;
//                }
//            }
//            if (left < right) {
//                return 0;
//            }
//
//            return 0;
//        }
//
//        private int[] getBits() {
//            int[] bits = new int[MAX_BITS_COUNT];
//            int a = 1;
//            for (int i = 1; i < MAX_BITS_COUNT; i++) {
//                bits[i] = a;
//                a *= 2;
//            }
//            return bits;
//        }
//    }
}
