package joohoyo.leetcode.challenge._30day;

// Last Stone Weight
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/
// 19:17 ~ 19:27 (10min)

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastStoneWeight2 {
    @Test
    public void test() {
        LastStoneWeight2.Solution s = new LastStoneWeight2.Solution();

        assertEquals(1, s.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int s : stones) {
                pq.add(s);
            }
            while (pq.size() > 1) {
                int a = pq.poll();
                int b = pq.poll();
                if (a > b) {
                    pq.add(a - b);
                }
            }
            return pq.size() == 0 ? 0 : pq.poll();
        }
    }
}
