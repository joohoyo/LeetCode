package joohoyo.leetcode.challenge.june;

// Surrounded Regions
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
// 10:20 ~ 11:08 (48mins)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {
    Solution s;

    @BeforeEach
    public void init() {
        s = new Solution();
    }

    @Test
    public void test1() {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] expected = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};
        s.solve(board);
        assertDoubleArrayEquals(expected, board);
    }

    @Test
    public void test2() {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}};
        char[][] expected = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}};
        s.solve(board);
        assertDoubleArrayEquals(expected, board);
    }

    @Test
    public void test3() {
        char[][] board = new char[][]{{'O', 'O', 'O', 'O'}, {'O', 'X', 'X', 'O'}, {'O', 'X', 'X', 'O'}, {'O', 'O', 'O', 'O'}};
        char[][] expected = new char[][]{{'O', 'O', 'O', 'O'}, {'O', 'X', 'X', 'O'}, {'O', 'X', 'X', 'O'}, {'O', 'O', 'O', 'O'}};
        s.solve(board);
        assertDoubleArrayEquals(expected, board);
    }

    @Test
    public void test4() {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'O'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}};
        char[][] expected = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'O'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}};
        s.solve(board);
        assertDoubleArrayEquals(expected, board);
    }

    private void assertDoubleArrayEquals(char[][] expected, char[][] actual) {
        Assertions.assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                Assertions.assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

    class Solution {
        int[][] map;
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        public void solve(char[][] board) {
            int n = board.length;
            if (n == 0) {
                return;
            }

            int m = board[0].length;
            if (m == 0) {
                return;
            }

            map = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (board[i][j] == 'X') map[i][j] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) {
                        Set<String> points = new HashSet<>();
                        boolean surrounded = dfs(board, i, j, points);
                        for (String p : points) {
                            int x = Integer.parseInt(p.split(",")[0]);
                            int y = Integer.parseInt(p.split(",")[1]);
                            if (surrounded) {
                                board[x][y] = 'X';
                                map[x][y] = 1;
                            } else {
                                map[x][y] = -1;
                            }
                        }
                    }
                }
            }
        }

        private boolean dfs(char[][] board, int x, int y, Set<String> points) {
            points.add(x + "," + y);
            if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                return false;
            }

            for (int i = 0; i < 4; i++) {
                int x2 = x + directions[i][0];
                int y2 = y + directions[i][1];

                if (map[x2][y2] == -1) {
                    return false;
                }
                if (points.contains(x2 + "," + y2) || board[x2][y2] == 'X') {
                    continue;
                }

                if (dfs(board, x2, y2, points) == false) {
                    return false;
                }
            }
            return true;
        }
    }
}
