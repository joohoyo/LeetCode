package joohoyo.leetcode.challenge.may;

// Maximum Sum Circular Subarray
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
// 17:31 ~ gg (min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSumCircularSubarray {
    @Test
    public void test() {
        MaximumSumCircularSubarray.Solution s = new MaximumSumCircularSubarray.Solution();

        assertEquals(3, s.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        assertEquals(2, s.maxSubarraySumCircular(new int[]{1, 1}));
        assertEquals(10, s.maxSubarraySumCircular(new int[]{5, -3, 5}));
        assertEquals(4, s.maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        assertEquals(3, s.maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        assertEquals(-1, s.maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    class Solution {
        public int maxSubarraySumCircular(int[] A) {
            int total = 0;
            int maxSum = A[0];
            int minSum = A[0];
            int curMax = 0;
            int curMin = 0;
            for (int a : A) {
                total += a;
                curMax = Math.max(curMax + a, a);
                maxSum = Math.max(maxSum, curMax);
                curMin = Math.min(curMin + a, a);
                minSum = Math.min(minSum, curMin);
            }
            if (maxSum > 0) {
                return Math.max(maxSum, total - minSum);
            }
            return maxSum;
        }
    }
}
