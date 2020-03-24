package joohoyo.leetcode.problems.medium;

// 36. Valid Sudoku
// https://leetcode.com/problems/valid-sudoku/
// 17:27 ~ 17:43 (16min)

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M36 {
    @Test
    @DisplayName("파이팅")
    public void test() {
        M36.Solution s = new M36.Solution();

        char[][] input = new char[9][9];
//        input[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
//        input[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
//        input[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
//        input[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
//        input[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
//        input[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
//        input[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
//        input[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
//        input[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
//
        input[0] = new char[]{'.', '3', '.', '.', '7', '.', '.', '.', '.'};
        input[1] = new char[]{'.', '.', '.', '1', '9', '5', '.', '.', '.'};
        input[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        input[3] = new char[]{'.', '.', '.', '.', '6', '.', '.', '.', '3'};
        input[4] = new char[]{'.', '.', '.', '8', '.', '3', '.', '.', '1'};
        input[5] = new char[]{'.', '.', '.', '.', '2', '.', '.', '.', '6'};
        input[6] = new char[]{'.', '.', '.', '.', '.', '.', '2', '8', '.'};
        input[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        input[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};


        assertEquals(true, s.isValidSudoku(input));
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int n = board.length;

            for (int i = 0; i < n; i++) {
                Set<String> rows = new HashSet<>();
                Set<String> columns = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (i % 3 == 0 && j % 3 == 0) {
                        if (!isSubBoxGood(board, i, j)) {
                            return false;
                        }
                    }
                    if (board[i][j] != '.') {
                        String rowNumber = Character.toString(board[i][j]);
                        if (rows.contains(rowNumber)) {
                            return false;
                        } else {
                            rows.add(rowNumber);
                        }
                    }
                    if (board[j][i] != '.') {
                        String columnNumber = Character.toString(board[j][i]);
                        if (columns.contains(columnNumber)) {
                            return false;
                        } else {
                            columns.add(columnNumber);
                        }
                    }
                }
            }

            return true;
        }

        private boolean isSubBoxGood(char[][] board, int x, int y) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String number = Character.toString(board[x + i][y + j]);
                    if (number.equals(".")) {
                        continue;
                    }
                    if (set.contains(number)) {
                        return false;
                    }
                    set.add(number);
                }
            }
            return true;
        }
    }
}