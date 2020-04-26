package joohoyo.leetcode.contest;

// 5394. Diagonal Traverse II
// https://leetcode.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/
// medium
// 12:13 ~ (min)
// Time Limit Exceeded

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class C186_5394_2 {
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
            int n = nums.size();
            int m = 0;
            int totalCount = 0;
            for (List<Integer> numList : nums) {
                m = Math.max(m, numList.size());
                totalCount += numList.size();
            }

            int[] answer = new int[totalCount];
            int count = 1;
            for (int i = 0; i < totalCount; ) {
                for (int j = count - 1; j >= 0; j--) {
                    if (nums.get(j).size() > 0) {
                        answer[i++] = nums.get(j).remove(0);
                    }
                }
                count = Math.min(count + 1, n);
            }

            return answer;
        }
    }
}
