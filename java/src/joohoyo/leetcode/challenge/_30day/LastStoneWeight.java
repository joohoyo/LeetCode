package joohoyo.leetcode.challenge._30day;

// Last Stone Weight
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3297/
// 19:17 ~ 19:27 (10min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastStoneWeight {
    @Test
    public void test() {
        LastStoneWeight.Solution s = new LastStoneWeight.Solution();

        assertEquals(1, s.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    class Solution {
        public int lastStoneWeight(int[] stones) {
            List<Integer> stoneList = new ArrayList<>();
            for (int i = 0; i < stones.length; i++) {
                stoneList.add(stones[i]);
            }

            while (stoneList.size() > 1) {
                Collections.sort(stoneList, Collections.reverseOrder());
                int a = stoneList.get(0);
                int b = stoneList.get(1);
                stoneList.remove(0);
                stoneList.remove(0);
                if (a != b) {
                    stoneList.add(0, Math.abs(a - b));
                }
            }
            return stoneList.size() == 0 ? 0 : stoneList.get(0);
        }
    }
}
