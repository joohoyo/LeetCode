package joohoyo.leetcode.problems.medium;

// 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/
// 14:53 ~ 15:08 (15min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class M54 {
    @Test
    public void test() {
        M54.Solution s = new M54.Solution();

        assertIterableEquals(
                Arrays.asList(),
                s.spiralOrder(new int[][]{{}, {}, {}})
        );
        assertIterableEquals(
                Arrays.asList(1, 2, 3),
                s.spiralOrder(new int[][]{{1}, {2}, {3}})
        );
        assertIterableEquals(
                Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5),
                s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
        );
        assertIterableEquals(
                Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
                s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})
        );
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> answers = new ArrayList<>();
            if (matrix.length == 0) {
                return answers;
            }
            int x = 0;
            int y = -1;
            int m = matrix.length;
            int n = matrix[0].length;
            int direction = 0;
            int[][] map = new int[m][n];

            for (int i = 0; i < m * n; i++) {
                while (true) {
                    if (direction == 0) {
                        if (y == n - 1 || map[x][y + 1] == 1) {
                            direction = 1;
                        } else {
                            y++;
                            break;
                        }
                    }
                    if (direction == 1) {
                        if (x == m - 1 || map[x + 1][y] == 1) {
                            direction = 2;
                        } else {
                            x++;
                            break;
                        }
                    }
                    if (direction == 2) {
                        if (y == 0 || map[x][y - 1] == 1) {
                            direction = 3;
                        } else {
                            y--;
                            break;
                        }
                    }
                    if (direction == 3) {
                        if (x == 0 || map[x - 1][y] == 1) {
                            direction = 0;
                        } else {
                            x--;
                            break;
                        }
                    }
                }
                answers.add(matrix[x][y]);
                map[x][y] = 1;
            }

            return answers;
        }
    }
}
