package joohoyo.leetcode.challenge.may;

// Possible Bipartition
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/
// 19:14 ~ gg (min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PossibleBipartition2 {
    @Test
    public void test() {
        PossibleBipartition2.Solution s = new PossibleBipartition2.Solution();

        assertEquals(true, s.possibleBipartition(1, new int[][]{}));
        assertEquals(true, s.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        assertEquals(false, s.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        assertEquals(false, s.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        assertEquals(true, s.possibleBipartition(3, new int[][]{{1, 2}, {2, 3}}));
        assertEquals(true, s.possibleBipartition(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 6}}));
        assertEquals(true, s.possibleBipartition(10, new int[][]{{4, 7}, {4, 8}, {2, 8}, {8, 9}, {1, 6}, {5, 8}, {1, 2}, {6, 7}, {3, 10}, {8, 10}, {1, 5}, {7, 10}, {1, 10}, {3, 5}, {3, 6}, {1, 4}, {3, 9}, {2, 3}, {1, 9}, {7, 9}, {2, 7}, {6, 8}, {5, 7}, {3, 4}}));
    }

    class Solution {
        Map<Integer, Integer> colors;
        List<List<Integer>> edges;

        public boolean possibleBipartition(int N, int[][] dislikes) {
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }
            for (int[] dislike : dislikes) {
                edges.get(dislike[0]).add(dislike[1]);
                edges.get(dislike[1]).add(dislike[0]);
            }

            colors = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                if (colors.containsKey(i)) {
                    continue;
                }

                if (dfs(i, 0) == false) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int node, int color) {
            if (colors.containsKey(node)) {
                return colors.get(node) == color;
            }
            colors.put(node, color);

            for (Integer neighbor : edges.get(node)) {
                if (dfs(neighbor, color ^ 1) == false) {
                    return false;
                }
            }
            return true;
        }
    }
}
