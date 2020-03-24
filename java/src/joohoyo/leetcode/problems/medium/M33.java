package joohoyo.leetcode.problems.medium;

// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/
// 12:18 ~ 12:41, 12:55 ~ 1:09, 2:24~ 2:30 (43min)

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M33 {
    @Test
    @DisplayName("파이팅")
    public void test() {
        M33.Solution s = new M33.Solution();
        assertEquals(1, s.search(new int[]{5, 1, 2, 3, 4}, 1));
        assertEquals(6, s.search(new int[]{8, 1, 2, 3, 4, 5, 6, 7}, 6));
        assertEquals(-1, s.search(new int[]{1}, 0));
        assertEquals(0, s.search(new int[]{1}, 1));
        assertEquals(-1, s.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0));
        assertEquals(8, s.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
        assertEquals(2, s.search(new int[]{2, 3, 4, 5, 6, 0, 1}, 4));
        assertEquals(4, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    class Solution {
        public int find(int[] nums, int target, int l, int r) {
            if (l > r) {
                return -1;
            }
            if (l == r) {
                if (nums[l] == target) {
                    return l;
                }
                return -1;
            }

            int c = (int) ((r + l) / 2);
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            if (nums[c] == target) {
                return c;
            }
            if (nums[c + 1] == target) {
                return c + 1;
            }


            int f = find(nums, target, l, c);
            if (f != -1) {
                return f;
            }
            return find(nums, target, c + 1, r);
        }

        public int search(int[] nums, int target) {
            return find(nums, target, 0, nums.length - 1);
        }
    }
}
