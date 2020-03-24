package joohoyo.leetcode.problems.medium;

// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// 10:47 ~ 10:57 (10min)

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class M34 {
    @Test
    @DisplayName("파이팅")
    public void test() {
        M34.Solution s = new M34.Solution();

        assertArrayEquals(new int[]{3, 4}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[]{5, 5}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10));
        assertArrayEquals(new int[]{-1, -1}, s.searchRange(new int[]{1}, 10));
        assertArrayEquals(new int[]{0, 0}, s.searchRange(new int[]{1}, 1));
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = -1;
            int end = -1;
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    if (start == -1) {
                        start = i;
                    }
                    end = i;
                }
            }
            return new int[]{start, end};
        }
    }
}