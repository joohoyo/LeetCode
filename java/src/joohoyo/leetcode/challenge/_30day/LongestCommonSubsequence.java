package joohoyo.leetcode.challenge._30day;

// Longest Common Subsequence
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3311/
// 14:52 ~ 15:11 (19min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonSubsequence {
    @Test
    public void test() {
        LongestCommonSubsequence.Solution s = new LongestCommonSubsequence.Solution();

        assertEquals(3, s.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, s.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, s.longestCommonSubsequence("abc", "def"));
        assertEquals(9, s.longestCommonSubsequence("lcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmva", "bklgfivmpozinybwlovcnafqfybodkhabyrglsnen"));
    }

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int n = text1.length();
            int m = text2.length();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                String t1 = text1.substring(i, i + 1);
                for (int j = 0; j < m; j++) {
                    int up = i > 0 ? map[i - 1][j] : 0;
                    int left = j > 0 ? map[i][j - 1] : 0;
                    String t2 = text2.substring(j, j + 1);
                    if (t1.equals(t2)) {
                        if (i > 0 && j > 0) {
                            map[i][j] = map[i - 1][j - 1] + 1;
                        } else {
                            map[i][j] = 1;
                        }
                    } else {
                        map[i][j] = Math.max(up, left);
                    }
                }
            }
            return map[n - 1][m - 1];
        }
    }
}
