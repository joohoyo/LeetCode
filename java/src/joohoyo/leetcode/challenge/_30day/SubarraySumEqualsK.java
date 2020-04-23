package joohoyo.leetcode.challenge._30day;

// Subarray Sum Equals K
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3307/
// 18:01 ~ gg (min)

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubarraySumEqualsK {
    @Test
    public void test() {
        SubarraySumEqualsK.Solution s = new SubarraySumEqualsK.Solution();

        assertEquals(2, s.subarraySum(new int[]{1, 1, 1}, 2));
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int count = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
