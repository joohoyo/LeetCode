package joohoyo.leetcode.challenge._30day;

// Maximum Subarray
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3285/
// 22:03 ~ (min)
// E53과 같은 문제


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarray {
    @Test
    public void test() {
        MaximumSubarray.Solution s = new MaximumSubarray.Solution();

        assertEquals(6, s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    class Solution {
        public int maxSubArray(int[] nums) {
            int answer = nums[0];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum > answer) {
                    answer = sum;
                }
                if (sum < 0) {
                    sum = 0;
                }
            }
            return answer;
        }
    }
}
