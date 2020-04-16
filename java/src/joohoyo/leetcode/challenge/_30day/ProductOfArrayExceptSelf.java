package joohoyo.leetcode.challenge._30day;

// Product of Array Except Self
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3300/
// 18:36 ~ gg (min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelf {
    @Test
    public void test() {
        ProductOfArrayExceptSelf.Solution s = new ProductOfArrayExceptSelf.Solution();

        assertArrayEquals(new int[]{24, 12, 8, 6}, s.productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{2, 1}, s.productExceptSelf(new int[]{1, 2}));
        assertArrayEquals(new int[]{12, 8, 6}, s.productExceptSelf(new int[]{2, 3, 4}));
        assertArrayEquals(new int[]{0, 0}, s.productExceptSelf(new int[]{0, 0}));
        assertArrayEquals(new int[]{2, 0, 0}, s.productExceptSelf(new int[]{0, 1, 2}));
        assertArrayEquals(new int[]{0, 1}, s.productExceptSelf(new int[]{1, 0}));
    }

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }
            int right = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= right;
                right *= nums[i];
            }
            return res;
        }
    }
}
