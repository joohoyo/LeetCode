package joohoyo.leetcode.challenge._30day;

// Number of Islands
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/
// 17:35 ~ 17:48 (13min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfIslands {
    @Test
    public void test() {
        NumberOfIslands.Solution s = new NumberOfIslands.Solution();

        Assertions.assertEquals(
                1,
                s.numIslands(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }));

        Assertions.assertEquals(
                3,
                s.numIslands(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                })
        );
        Assertions.assertEquals(0, s.numIslands(new char[][]{}));
        Assertions.assertEquals(1, s.numIslands(new char[][]{{'1'}, {'1'}}));

    }

    class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0) {
                return 0;
            }

            int count = 0;
            int[][] map = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && map[i][j] == 0) {
                        count++;
                        find(grid, map, i, j);
                    }
                }
            }

            return count;
        }

        private void find(char[][] grid, int[][] map, int x, int y) {
            if (x < 0 || y < 0 || x == grid.length || y == grid[0].length) {
                return;
            }
            if (grid[x][y] == '0') {
                return;
            }
            if (map[x][y] == 1) {
                return;
            }
            map[x][y] = 1;
            find(grid, map, x - 1, y);
            find(grid, map, x, y - 1);
            find(grid, map, x + 1, y);
            find(grid, map, x, y + 1);
        }
    }
}
