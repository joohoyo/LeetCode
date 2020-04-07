package joohoyo.leetcode.challenge._30day;

// Counting Elements
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
// 17:28 ~ 17:38 (10min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {
    @Test
    public void test() {
        CountingElements.Solution s = new CountingElements.Solution();

        Assertions.assertEquals(0, s.countElements(new int[]{}));
        Assertions.assertEquals(2, s.countElements(new int[]{1, 1, 2}));
        Assertions.assertEquals(2, s.countElements(new int[]{1, 2, 3}));
        Assertions.assertEquals(0, s.countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
        Assertions.assertEquals(3, s.countElements(new int[]{1, 3, 2, 3, 5, 0}));
        Assertions.assertEquals(2, s.countElements(new int[]{1, 1, 2, 2}));
    }

    class Solution {
        public int countElements(int[] arr) {
            Map<Integer, Integer> numbers = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                numbers.put(arr[i], numbers.getOrDefault(arr[i], 0) + 1);
            }

            int count = 0;
            for (Integer number : numbers.keySet()) {
                if (numbers.containsKey(number + 1)) {
                    count += numbers.get(number);
                }
            }
            return count;
        }
    }
}
