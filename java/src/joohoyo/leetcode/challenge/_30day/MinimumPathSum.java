package joohoyo.leetcode.challenge._30day;

// Minimum Path Sum
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3303/
// 19:00 ~ 19:18 (18min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumPathSum {
    @Test
    public void test() {
        MinimumPathSum.Solution s = new MinimumPathSum.Solution();

        assertEquals(0, s.minPathSum(new int[][]{}));
        assertEquals(7, s.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }

            int n = grid.length;
            int m = grid[0].length;

            int[][] map = new int[n][m];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    int v = grid[x][y];

                    if (x >= 1 && y >= 1) {
                        v = Math.min(v + map[x - 1][y], v + map[x][y - 1]);
                    } else if (x >= 1) {
                        v = v + map[x - 1][y];
                    } else if (y >= 1) {
                        v = v + map[x][y - 1];
                    }

                    if (map[x][y] == 0) {
                        map[x][y] = v;
                    } else {
                        map[x][y] = Math.min(map[x][y], v);
                    }
                }
            }

            return map[n - 1][m - 1];
        }
    }
}
