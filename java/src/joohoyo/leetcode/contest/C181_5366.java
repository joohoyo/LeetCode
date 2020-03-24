package joohoyo.leetcode.contest;

// 5366. Check if There is a Valid Path in a Grid
// https://leetcode.com/contest/weekly-contest-181/problems/check-if-there-is-a-valid-path-in-a-grid/
// 11:54 ~ 12:35 (41min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class C181_5366 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals(true, s.hasValidPath(new int[][]{{2, 4, 3}, {6, 5, 2}}));
        Assertions.assertEquals(false, s.hasValidPath(new int[][]{{1, 2, 1}, {1, 2, 1}}));
        Assertions.assertEquals(false, s.hasValidPath(new int[][]{{1, 1, 2}}));
        Assertions.assertEquals(true, s.hasValidPath(new int[][]{{1, 1, 1, 1, 1, 1, 3}}));
        Assertions.assertEquals(true, s.hasValidPath(new int[][]{{2}, {2}, {2}, {2}, {2}, {2}, {6}}));
    }

    class Solution {
        Map<Integer, List<List<Integer>>> directions = new HashMap<>();

        private boolean path(int[][] grid, int[][] map, int x, int y) {
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return true;
            }
            if (map[x][y] == 1) {
                return false;
            }
            map[x][y] = 1;
            List<List<Integer>> direction = directions.get(grid[x][y]);
            for (int i = 0; i < 4; i++) {
                int nextX = x;
                int nextY = y;
                if (i == 0) { // down
                    nextX = x + 1;
                } else if (i == 1) { // left
                    nextY = y - 1;
                } else if (i == 2) { // up
                    nextX = x - 1;
                } else if (i == 3) { //right
                    nextY = y + 1;
                }
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || map[nextX][nextY] == 1) {
                    continue;
                }
                for (int j : direction.get(i)) {
                    if (j == grid[nextX][nextY]) {
                        if (path(grid, map, nextX, nextY)) {
                            return true;
                        }
                    }
                }
            }
            map[x][y] = 0;
            return false;
        }

        private List<List<Integer>> getDirection(int street) {
            List<Integer> directionDown = new ArrayList<>();
            List<Integer> directionLeft = new ArrayList<>();
            List<Integer> directionUp = new ArrayList<>();
            List<Integer> directionRight = new ArrayList<>();

            if (street == 1) {
                directionLeft = Arrays.asList(1, 4, 6);
                directionRight = Arrays.asList(1, 3, 5);
            } else if (street == 2) {
                directionUp = Arrays.asList(2, 3, 4);
                directionDown = Arrays.asList(2, 5, 6);
            } else if (street == 3) {
                directionLeft = Arrays.asList(1, 4, 6);
                directionDown = Arrays.asList(2, 5, 6);
            } else if (street == 4) {
                directionRight = Arrays.asList(1, 3, 5);
                directionDown = Arrays.asList(2, 5, 6);
            } else if (street == 5) {
                directionLeft = Arrays.asList(1, 4, 6);
                directionUp = Arrays.asList(2, 3, 4);
            } else {
                directionRight = Arrays.asList(1, 3, 5);
                directionUp = Arrays.asList(2, 3, 4);
            }

            List<List<Integer>> direction = new ArrayList<>();
            direction.add(directionDown);
            direction.add(directionLeft);
            direction.add(directionUp);
            direction.add(directionRight);

            return direction;
        }

        public boolean hasValidPath(int[][] grid) {
            for (int i = 1; i <= 6; i++) {
                directions.put(i, getDirection(i));
            }
            int[][] map = new int[grid.length][grid[0].length];

            return path(grid, map, 0, 0);
        }
    }
}
