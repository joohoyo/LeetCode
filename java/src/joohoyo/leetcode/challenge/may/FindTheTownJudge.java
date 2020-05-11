package joohoyo.leetcode.challenge.may;

// Find the Town Judge
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
// 23:31 ~ 23:45 (14min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheTownJudge {
    @Test
    public void test() {
        FindTheTownJudge.Solution s = new FindTheTownJudge.Solution();

        assertEquals(2, s.findJudge(2, new int[][]{{1, 2}}));
        assertEquals(3, s.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        assertEquals(-1, s.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        assertEquals(-1, s.findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        assertEquals(3, s.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }

    class Solution {
        public int findJudge(int N, int[][] trust) {
            int[] trustCount = new int[N + 1];
            int[] trustedCount = new int[N + 1];

            for (int i = 0; i < trust.length; i++) {
                trustCount[trust[i][0]]++;
                trustedCount[trust[i][1]]++;
            }

            for (int i = 1; i <= N; i++) {
                if (trustCount[i] == 0 && trustedCount[i] == N - 1) {
                    return i;
                }
            }

            return -1;
        }
    }
}
