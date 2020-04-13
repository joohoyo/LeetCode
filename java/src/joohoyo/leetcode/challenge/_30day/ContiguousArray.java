package joohoyo.leetcode.challenge._30day;

// Contiguous Array
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3298/
// 17:04 ~ gg (min)

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContiguousArray {
    @Test
    public void test() {
        ContiguousArray.Solution s = new ContiguousArray.Solution();

        assertEquals(2, s.findMaxLength(new int[]{0, 1, 0, 0}));
        assertEquals(2, s.findMaxLength(new int[]{1, 0}));
        assertEquals(2, s.findMaxLength(new int[]{0, 1, 0}));
        assertEquals(4, s.findMaxLength(new int[]{0, 1, 0, 0, 1}));
        assertEquals(6, s.findMaxLength(new int[]{0, 0, 0, 1, 1, 1, 0}));
    }

    class Solution {
        public int findMaxLength(int[] nums) {
            int answer = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += nums[i] == 0 ? -1 : 1;
                if (map.containsKey(count)) {
                    answer = Math.max(answer, i - map.get(count));
                } else {
                    map.put(count, i);
                }
            }
            return answer;
        }
    }
}
