package joohoyo.leetcode.contest;

// 5356. Lucky Numbers in a Matrix
// https://leetcode.com/contest/weekly-contest-180/problems/lucky-numbers-in-a-matrix/
// 12:05 ~ 12:43 (38min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class C180_5356 {
    @Test
    public void test() {
        C180_5356.Solution s = new C180_5356.Solution();

        int[][] i1 = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        assertTrue(Arrays.asList(15).equals(s.luckyNumbers(i1)));

        int[][] i2 = new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        assertTrue(Arrays.asList(12).equals(s.luckyNumbers(i2)));

        int[][] i3 = new int[][]{{36376, 85652, 21002, 4510}, {68246, 64237, 42962, 9974}, {32768, 97721, 47338, 5841}, {55103, 18179, 79062, 46542}};
        assertTrue(Arrays.asList().equals(s.luckyNumbers(i3)));
    }

    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            List<Integer> answer = new ArrayList<>();
            int maxElement = -1;
            int[][] elements = new int[m][3];

            for (int i = 0; i < m; i++) {
                int max = -1;
                int min = (int) Math.pow(10, 5) + 1;
                int minj = 0;
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, matrix[i][j]);
                    if (min > matrix[i][j]) {
                        min = matrix[i][j];
                        minj = j;
                    }

                }
                elements[i][0] = max;
                elements[i][1] = min;
                elements[i][2] = minj;
                maxElement = Math.max(maxElement, max);
            }

            for (int i = 0; i < m; i++) {
                if (elements[i][0] == maxElement) {
                    int max = -1;
                    for (int j = 0; j < m; j++) {
                        if (max < matrix[j][elements[i][2]]) {
                            max = matrix[j][elements[i][2]];
                        }
                    }
                    if (max == elements[i][1]) {
                        answer.add(elements[i][1]);
                    }
                    break;
                }
            }

            return answer;
        }
    }

}
