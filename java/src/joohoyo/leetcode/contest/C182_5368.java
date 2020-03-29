package joohoyo.leetcode.contest;

// 5368. Find Lucky Integer in an Array
// https://leetcode.com/contest/weekly-contest-182/problems/find-lucky-integer-in-an-array/
// 11:31 ~ 11:36 (5min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class C182_5368 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals(2, s.findLucky(new int[]{2, 2, 3, 4}));
        Assertions.assertEquals(3, s.findLucky(new int[]{1, 2, 2, 3, 3, 3}));
        Assertions.assertEquals(-1, s.findLucky(new int[]{2, 2, 2, 3, 3}));
        Assertions.assertEquals(-1, s.findLucky(new int[]{}));
    }

    class Solution {
        public int findLucky(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i], 0);
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            int answer = -1;
            for (Integer i : map.keySet()) {
                if (i == map.get(i) && i > answer) {
                    answer = i;
                }
            }

            return answer;
        }
    }
}
