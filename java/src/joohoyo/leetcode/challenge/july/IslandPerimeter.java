package joohoyo.leetcode.challenge.july;

// Island Perimeter
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/
// 16:02 ~ 16:18 (16mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandPerimeter {
    @Test
    public void test() {
        IslandPerimeter.Solution s = new IslandPerimeter.Solution();

        assertEquals(16, s.islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        assertEquals(4, s.islandPerimeter(new int[][]{{1}}));
    }

    class Solution {
        public int islandPerimeter(int[][] grid) {
            int answer = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }

                    int p = 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        p--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        p--;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        p--;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        p--;
                    }
                    answer += p;
                }
            }
            return answer;
        }
    }
}
