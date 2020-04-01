package joohoyo.leetcode.challenge._30day;

// Single Number
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
// 16:49 ~ 17:01 (12min)
// Solution이 재밌음

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumber {
    @Test
    public void test() {
        SingleNumber.Solution s = new SingleNumber.Solution();

        assertEquals(1, s.singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, s.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            for (Integer key : map.keySet()) {
                if (map.get(key) == 1) {
                    return key;
                }
            }
            return 0;
        }
    }
}
