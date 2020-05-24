package joohoyo.leetcode.challenge.may;

// Interval List Intersections
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
// 22:29 ~ 22:55 (26min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntervalListIntersections {
    @Test
    public void test() {
        IntervalListIntersections.Solution s = new IntervalListIntersections.Solution();

        assertDoubleArrayEquals(
                new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}},
                s.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})
        );

        assertDoubleArrayEquals(
                new int[][]{},
                s.intervalIntersection(new int[][]{{0, 1}, {2, 3}}, new int[][]{{4, 5}, {6, 7}})
        );

        assertDoubleArrayEquals(
                new int[][]{},
                s.intervalIntersection(new int[][]{}, new int[][]{})
        );


        assertDoubleArrayEquals(
                new int[][]{{1, 2}, {3, 4}},
                s.intervalIntersection(new int[][]{{0, 10}}, new int[][]{{1, 2}, {3, 4}})
        );

        assertDoubleArrayEquals(
                new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}},
                s.intervalIntersection(new int[][]{{0, 1}, {2, 3}, {4, 5}}, new int[][]{{1, 2}, {3, 4}})
        );


    }

    private void assertDoubleArrayEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        if (expected.length == 0) {
            return;
        }

        assertEquals(expected[0].length, actual[0].length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            int indexA = 0;
            int indexB = 0;
            List<int[]> answer = new ArrayList<>();
            while (indexA < A.length && indexB < B.length) {
                int head = getHead(A[indexA], B[indexB]);
                int tail = getTail(A[indexA], B[indexB]);
                if (head != -1 && tail != -1) {
                    answer.add(new int[]{head, tail});
                }

                if (A[indexA][1] < B[indexB][1]) {
                    indexA++;
                } else if (A[indexA][1] > B[indexB][1]) {
                    indexB++;
                } else {
                    indexA++;
                    indexB++;
                }
            }
            return answer.toArray(new int[answer.size()][2]);
        }

        private int getHead(int A[], int B[]) {
            if (A[0] <= B[0] && B[0] <= A[1]) {
                return B[0];
            }
            if (B[0] <= A[0] && A[0] <= B[1]) {
                return A[0];
            }
            return -1;
        }

        private int getTail(int A[], int B[]) {
            if (B[0] <= A[1] && A[1] <= B[1]) {
                return A[1];
            }
            if (A[0] <= B[1] && B[1] <= A[1]) {
                return B[1];
            }
            return -1;
        }
    }
}
