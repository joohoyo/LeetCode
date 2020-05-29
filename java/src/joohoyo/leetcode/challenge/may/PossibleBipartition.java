package joohoyo.leetcode.challenge.may;

// Possible Bipartition
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
// 19:14 ~ gg (min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PossibleBipartition {
    @Test
    public void test() {
        PossibleBipartition.Solution s = new PossibleBipartition.Solution();

        assertEquals(true, s.possibleBipartition(1, new int[][]{}));
        assertEquals(true, s.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        assertEquals(false, s.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        assertEquals(false, s.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        assertEquals(true, s.possibleBipartition(3, new int[][]{{1, 2}, {2, 3}}));
        assertEquals(true, s.possibleBipartition(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 6}}));
        assertEquals(true, s.possibleBipartition(10, new int[][]{{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10}, {8, 10}, {1, 5}, {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9}, {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}}));
    }

    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            if (dislikes.length == 0) {
                return true;
            }

            int check[] = new int[N + 1];

            for (int i = 0; i < dislikes.length; i++) {
                int first = check[dislikes[i][0]];
                int second = check[dislikes[i][1]];
                if (first == 0 && second == 0) {
                    check[dislikes[i][0]] = 1;
                    check[dislikes[i][1]] = 2;
                    continue;
                }
                if (first == 0 || second == 0) {
                    if (first == 0) {
                        check[dislikes[i][0]] = check[dislikes[i][1]] % 2 + 1;
                    } else {
                        check[dislikes[i][1]] = check[dislikes[i][0]] % 2 + 1;
                    }
                    continue;
                }
                if ((first + second) % 2 == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
