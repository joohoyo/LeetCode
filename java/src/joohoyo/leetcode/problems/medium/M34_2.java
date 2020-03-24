package joohoyo.leetcode.problems.medium;

// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// 11:02 ~ 11:13 (11min)

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class M34_2 {
    @Test
    @DisplayName("파이팅")
    public void test() {
        M34_2.Solution s = new M34_2.Solution();

        assertArrayEquals(new int[]{0, 3}, s.searchRange(new int[]{1, 1, 1, 1}, 1));
        assertArrayEquals(new int[]{3, 4}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[]{5, 5}, s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10));
        assertArrayEquals(new int[]{-1, -1}, s.searchRange(new int[]{1}, 10));
        assertArrayEquals(new int[]{0, 0}, s.searchRange(new int[]{1}, 1));
    }

    class Solution {
        private int search(int[] nums, int target, int l, int r) {
            if (l >= r) {
                return -1;
            }
            int c = (l + r) / 2;
            if (nums[c] == target) {
                return c;
            }
            if (nums[c] > target) {
                return search(nums, target, l, c);
            }
            return search(nums, target, c + 1, r);
        }

        public int[] searchRange(int[] nums, int target) {
            int start = search(nums, target, 0, nums.length);
            if (start == -1) {
                return new int[]{-1, -1};
            }

            int end = start;
            while (true) {
                if (start > 0 && nums[start - 1] == target) {
                    start--;
                } else {
                    break;
                }
            }
            while (true) {
                if (end < nums.length - 1 && nums[end + 1] == target) {
                    end++;
                } else {
                    break;
                }
            }

            return new int[]{start, end};
        }
    }
}