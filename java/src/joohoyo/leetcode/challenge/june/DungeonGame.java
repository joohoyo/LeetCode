package joohoyo.leetcode.challenge.june;

// Dungeon Game
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/
// 10:53 ~ gg (mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DungeonGame {
    @Test
    public void test() {
        DungeonGame.Solution s = new DungeonGame.Solution();
        assertEquals(1, s.calculateMinimumHP(new int[][]{{0, 5}, {-2, -3}}));
        assertEquals(7, s.calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        assertEquals(1, s.calculateMinimumHP(new int[][]{{1, 1}, {1, 1}}));
    }

    class Solution {
        int n, m;
        int[][] map;

        public int calculateMinimumHP(int[][] dungeon) {
            n = dungeon.length;
            m = dungeon[0].length;
            map = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    map[i][j] = Integer.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    int current = dungeon[i][j];
                    int right = getHealth(current, i, j + 1);
                    int down = getHealth(current, i + 1, j);
                    int next = Math.min(right, down);
                    if (next == Integer.MAX_VALUE) {
                        map[i][j] = current >= 0 ? 1 : 1 - current;
                    } else {
                        map[i][j] = next;
                    }
                }
            }
            return map[0][0];
        }

        private int getHealth(int current, int x, int y) {
            if (x == n || y == m) {
                return Integer.MAX_VALUE;
            }
            int next = map[x][y];
            return Math.max(1, next - current);
        }
    }
}
