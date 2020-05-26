package joohoyo.leetcode.challenge.may;

// Uncrossed Lines
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/
// 10:47 ~ gg (min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UncrossedLines {
    @Test
    public void test() {
        UncrossedLines.Solution s = new UncrossedLines.Solution();

        assertEquals(0, s.maxUncrossedLines(new int[]{}, new int[]{}));
        assertEquals(2, s.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        assertEquals(3, s.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        assertEquals(2, s.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
        assertEquals(3, s.maxUncrossedLines(new int[]{1, 1, 2, 1, 2}, new int[]{1, 3, 2, 3, 1}));
        assertEquals(2, s.maxUncrossedLines(new int[]{2, 3, 1}, new int[]{3, 1, 3, 3, 3, 3}));
        assertEquals(2, s.maxUncrossedLines(new int[]{2, 1}, new int[]{1, 2, 1, 3, 3, 2}));
    }

    class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i == m || j == n) {
                        dp[i][j] = 0;
                    } else if (A[i] == B[j]) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
            return dp[0][0];
        }
    }
}
