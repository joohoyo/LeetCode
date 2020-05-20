package joohoyo.leetcode.problems.medium;

// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/
// 12:22 ~ 12:52 (30min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class M56 {
    @Test
    public void test() {
        M56.Solution s = new M56.Solution();

        assertDoubleArrayEquals(
                new int[][]{{0, 5}},
                s.merge(new int[][]{{1, 4}, {0, 2}, {3, 5}})
        );

        assertDoubleArrayEquals(
                new int[][]{{1, 6}, {8, 10}, {15, 18}},
                s.merge(new int[][]{{15, 18}, {2, 6}, {8, 10}, {1, 3}})
        );

        assertDoubleArrayEquals(
                new int[][]{{1, 5}},
                s.merge(new int[][]{{1, 4}, {4, 5}})
        );

        assertDoubleArrayEquals(
                new int[][]{{1, 4}},
                s.merge(new int[][]{{1, 4}, {2, 3}})
        );
    }

    private void assertDoubleArrayEquals(int[][] expected, int[][] actual) {
        Assertions.assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                Assertions.assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

    class Solution {
        public int[][] merge(int[][] intervals) {
            for (int i = 0; i < intervals.length; i++) {
                for (int j = i + 1; j < intervals.length; j++) {
                    if (intervals[i][0] > intervals[j][0]) {
                        int temp = intervals[i][0];
                        intervals[i][0] = intervals[j][0];
                        intervals[j][0] = temp;
                        temp = intervals[i][1];
                        intervals[i][1] = intervals[j][1];
                        intervals[j][1] = temp;
                    }
                }
            }

            List<Integer[]> list = new ArrayList<>();
            int[] check = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                if (check[i] == 1) {
                    continue;
                }
                Integer[] item = new Integer[]{intervals[i][0], intervals[i][1]};
                for (int j = i + 1; j < intervals.length; j++) {
                    if (intervals[j][0] <= item[1]) {
                        item[1] = Math.max(item[1], intervals[j][1]);
                        check[j] = 1;
                    } else {
                        break;
                    }
                }
                list.add(item);
            }

            int[][] answer = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                answer[i][0] = list.get(i)[0];
                answer[i][1] = list.get(i)[1];
            }

            return answer;
        }
    }
}


