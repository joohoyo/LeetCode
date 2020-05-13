package joohoyo.leetcode.challenge.may;

// Single Element in a Sorted Array
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
// 17:16 ~ 17:19 (3min)

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleElementInASortedArray {
    @Test
    public void test() {
        SingleElementInASortedArray.Solution s = new SingleElementInASortedArray.Solution();

        assertEquals(2, s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        assertEquals(10, s.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    set.remove(nums[i]);
                } else {
                    set.add(nums[i]);
                }
            }
            return set.iterator().next();
        }
    }
}
