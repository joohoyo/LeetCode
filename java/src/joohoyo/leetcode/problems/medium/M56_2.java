package joohoyo.leetcode.problems.medium;

// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/
// 12:22 ~ 12:52 (30min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class M56_2 {
    @Test
    public void test() {
        M56_2.Solution s = new M56_2.Solution();

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
            Collections.sort(Arrays.asList(intervals), (o1, o2) -> o1[0] < o2[0] ? -1 : o1[0] == o1[1] ? 0 : 1);
            List<int[]> answer = new ArrayList<>();
            for (int[] interval : intervals) {
                if (answer.isEmpty() || answer.get(answer.size() - 1)[1] < interval[0]) {
                    answer.add(interval);
                } else {
                    answer.get(answer.size() - 1)[1] = Math.max(answer.get(answer.size() - 1)[1], interval[1]);
                }
            }

            return answer.toArray(new int[answer.size()][]);
        }
    }
}


