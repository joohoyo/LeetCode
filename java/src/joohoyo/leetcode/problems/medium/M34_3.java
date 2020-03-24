package joohoyo.leetcode.problems.medium;

// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class M34_3 {
    @Test
    @DisplayName("파이팅")
    public void test() {
        M34_3.Solution s = new M34_3.Solution();

        s.searchRange(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 5);
    }

    public class Solution {
        public int[] searchRange(int[] A, int target) {
            int start = firstGreaterEqual(A, target);
            if (start == A.length || A[start] != target) {
                return new int[]{-1, -1};
            }
            return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
        }

        //find the first number that is greater than or equal to target.
        //could return A.length if target is greater than A[A.length-1].
        //actually this is the same as lower_bound in C++ STL.
        private int firstGreaterEqual(int[] A, int target) {
            int low = 0, high = A.length;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                //low <= mid < high
                if (A[mid] < target) {
                    low = mid + 1;
                } else {
                    //should not be mid-1 when A[mid]==target.
                    //could be mid even if A[mid]>target because mid<high.
                    high = mid;
                }
            }
            return low;
        }
    }

}