package joohoyo.leetcode.challenge.may;

// Single Element in a Sorted Array
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
// 17:16 ~ 17:19 (3min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleElementInASortedArray2 {
    @Test
    public void test() {
        SingleElementInASortedArray2.Solution s = new SingleElementInASortedArray2.Solution();

        assertEquals(2, s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        assertEquals(10, s.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == nums[mid + 1]) {
                    if ((mid - left) % 2 == 0) {
                        left = mid + 2;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid - 1] == nums[mid]) {
                    if ((mid - left - 1) % 2 == 0) {
                        left = mid + 1;
                    } else {
                        right = mid - 2;
                    }
                } else {
                    return nums[mid];
                }
            }
            return nums[left];
        }
    }
}
