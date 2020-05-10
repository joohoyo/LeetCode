package joohoyo.leetcode.challenge.may;

// Check If It Is a Straight Line
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
// 17:01 ~ 17:17 (16min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckIfItIsAStraightLine {
    @Test
    public void test() {
        CheckIfItIsAStraightLine.Solution s = new CheckIfItIsAStraightLine.Solution();

        assertEquals(true, s.checkStraightLine(new int[][]{{0, 1}, {1, 3}, {-4, -7}, {5, 11}}));
        assertEquals(true, s.checkStraightLine(new int[][]{{1, 1}, {2, 1}, {3, 1}}));
        assertEquals(true, s.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        assertEquals(false, s.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        assertEquals(true, s.checkStraightLine(new int[][]{{1, 1}, {1, 2}, {1, 3}}));
    }

    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates.length == 2) {
                return true;
            }

            double gradient = 0D;
            boolean finite = false;
            if (coordinates[0][1] - coordinates[1][1] == 0) {
                finite = true;
            } else {
                gradient = (double) (coordinates[0][0] - coordinates[1][0]) / (coordinates[0][1] - coordinates[1][1]);
            }
            for (int i = 2; i < coordinates.length; i++) {
                double denominator = coordinates[i][1] - coordinates[1][1];

                if (finite && denominator != 0) {
                    return false;
                } else if (finite && denominator == 0) {
                    continue;
                }

                double checkGradient = (coordinates[i][0] - coordinates[1][0]) / denominator;
                if (gradient != checkGradient) {
                    return false;
                }
            }
            return true;
        }
    }
}
