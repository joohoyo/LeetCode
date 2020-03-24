package joohoyo.leetcode.problems.medium;

// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/
// 12:18 ~ 12:41, 12:55 ~ 1:09, 2:24~ 2:30 (43min)

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M33_2 {
    @Test
    @DisplayName("파이팅")
    public void test() {
        M33_2.Solution s = new M33_2.Solution();
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

    public class Solution {
        public int search(int[] A, int target) {
            int lo = 0;
            int hi = A.length - 1;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (A[mid] == target) return mid;

                if (A[lo] <= A[mid]) {
                    if (target >= A[lo] && target < A[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    if (target > A[mid] && target <= A[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
            return A[lo] == target ? lo : -1;
        }

    }
}