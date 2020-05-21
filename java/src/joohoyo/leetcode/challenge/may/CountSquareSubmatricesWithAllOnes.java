package joohoyo.leetcode.challenge.may;

// Count Square Submatrices with All Ones
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
// 18:18 ~ 18:56 (38min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountSquareSubmatricesWithAllOnes {
    @Test
    public void test() {
        CountSquareSubmatricesWithAllOnes.Solution s = new CountSquareSubmatricesWithAllOnes.Solution();

        assertEquals(15, s.countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));
        assertEquals(7, s.countSquares(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
    }

    class Solution {
        public int countSquares(int[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }

            int row = matrix.length;
            int column = matrix[0].length;
            int[][] dp = new int[row + 1][column + 1];
            int answer = 0;
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    if (matrix[i - 1][j - 1] == 1) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                        answer += dp[i][j];
                    }
                }
            }
            return answer;
        }
    }
}
