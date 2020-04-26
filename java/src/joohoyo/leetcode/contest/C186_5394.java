package joohoyo.leetcode.contest;

// 5394. Diagonal Traverse II
// https://leetcode.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/
// medium
// 12:13 ~ (min)
// Time Limit Exceeded

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C186_5394 {
    @Test
    public void test1() {
        Solution s = new Solution();

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(4, 5, 6));
        list.add(Arrays.asList(7, 8, 9));
        Assertions.assertArrayEquals(new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9}, s.findDiagonalOrder(list));
    }

    @Test
    public void test2() {
        Solution s = new Solution();

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3, 4, 5));
        list.add(Arrays.asList(6, 7));
        list.add(Arrays.asList(8));
        list.add(Arrays.asList(9, 10, 11));
        list.add(Arrays.asList(12, 13, 14, 15, 16));
        Assertions.assertArrayEquals(new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16}, s.findDiagonalOrder(list));
    }

    @Test
    public void test3() {
        Solution s = new Solution();

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(4));
        list.add(Arrays.asList(5, 6, 7));
        list.add(Arrays.asList(8));
        list.add(Arrays.asList(9, 10, 11));
        Assertions.assertArrayEquals(new int[]{1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11}, s.findDiagonalOrder(list));
    }

    @Test
    public void test4() {
        Solution s = new Solution();

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, s.findDiagonalOrder(list));
    }

    @Test
    public void test5() {
        Solution s = new Solution();

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3));
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, s.findDiagonalOrder(list));
    }

    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int n = nums.size();
            int m = 0;
            int totalCount = 0;
            for (List<Integer> numList : nums) {
                m = Math.max(m, numList.size());
                totalCount += numList.size();
            }

            int[] answer = new int[totalCount];
            int x = 0;
            int y = 0;
            int z = 0;
            int nextX = 1;
            while (z < totalCount) {
                if (x < n && y < m) {
                    if (y < nums.get(x).size()) {
                        answer[z++] = nums.get(x).get(y);
                    }
                }
                x--;
                y++;
                if (x < 0) {
                    x = nextX;
                    nextX++;
                    y = 0;
                }
            }

            return answer;
        }
    }
}
