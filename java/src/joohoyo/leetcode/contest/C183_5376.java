package joohoyo.leetcode.contest;

// 5376. Minimum Subsequence in Non-Increasing Order
// https://leetcode.com/contest/weekly-contest-183/problems/minimum-subsequence-in-non-increasing-order/
// 11:32 ~ 11:42 (10min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C183_5376 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertIterableEquals(Arrays.asList(), s.minSubsequence(new int[]{}));
        Assertions.assertIterableEquals(Arrays.asList(10, 9), s.minSubsequence(new int[]{4, 3, 10, 9, 8}));
        Assertions.assertIterableEquals(Arrays.asList(7, 7, 6), s.minSubsequence(new int[]{4, 4, 7, 6, 7}));
        Assertions.assertIterableEquals(Arrays.asList(6), s.minSubsequence(new int[]{6}));

    }

    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            List<Integer> answers = new ArrayList<>();
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            int subSum = 0;
            int pointer = nums.length - 1;
            while (sum >= subSum && pointer >= 0) {
                subSum += nums[pointer];
                sum -= nums[pointer];
                answers.add(nums[pointer]);
                pointer--;

            }
            return answers;
        }
    }
}
