package joohoyo.leetcode.contest;

// 5394. Diagonal Traverse II
// https://leetcode.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/
// medium

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C186_5394_3 {
    @Test
    public void test1() {
        Solution s = new Solution();

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.get(0).add(1);
        list.get(0).add(2);
        list.get(0).add(3);
        list.get(1).add(4);
        list.get(1).add(5);
        list.get(1).add(6);
        list.get(2).add(7);
        list.get(2).add(8);
        list.get(2).add(9);
        Assertions.assertArrayEquals(new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9}, s.findDiagonalOrder(list));
    }

    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int n = 0, i = 0, maxKey = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int r = nums.size() - 1; r >= 0; --r) { // The values from the bottom rows are the starting values of the diagonals.
                for (int c = 0; c < nums.get(r).size(); ++c) {
                    map.putIfAbsent(r + c, new ArrayList<>());
                    map.get(r + c).add(nums.get(r).get(c));
                    maxKey = Math.max(maxKey, r + c);
                    n++;
                }
            }
            int[] ans = new int[n];
            for (int key = 0; key <= maxKey; ++key) {
                List<Integer> value = map.get(key);
                if (value == null) continue;
                for (int v : value) ans[i++] = v;
            }
            return ans;
        }
    }
}
