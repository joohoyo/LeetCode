package joohoyo.leetcode.challenge.july;

// Top K Frequent Elements
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
// 16:20 ~ 16:44 (24mins)

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopKFrequentElements {
    @Test
    public void test() {
        TopKFrequentElements.Solution s = new TopKFrequentElements.Solution();

        assertArrayEquals(new int[]{1, 2}, s.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{1}, s.topKFrequent(new int[]{1}, 1));
        assertArrayEquals(new int[]{1, 2}, s.topKFrequent(new int[]{1, 2}, 2));
    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            }

            PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>((Integer[] o1, Integer[] o2) -> {
                return (int) o2[1] - (int) o1[1];
            });

            counts.entrySet().forEach(e -> queue.offer(new Integer[]{e.getKey(), e.getValue()}));

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = queue.poll()[0];
            }
            return result;
        }
    }
}
