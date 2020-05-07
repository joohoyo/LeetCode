package joohoyo.leetcode.challenge.may;

// Majority Element
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
// 16:05 ~ 16:09 (4min)

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElement {
    @Test
    public void test() {
        MajorityElement.Solution s = new MajorityElement.Solution();

        assertEquals(3, s.majorityElement(new int[]{3, 2, 3}));
        assertEquals(2, s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    class Solution {
        public int majorityElement(int[] nums) {
            int limit = nums.length / 2;
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
                if (map.get(n) > limit) {
                    return n;
                }
            }
            return -1;
        }
    }
}
