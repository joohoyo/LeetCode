package joohoyo.leetcode.challenge.may;

// Flood Fill
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
// 16:33 ~ 16:52 (19min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FloodFill {
    @Test
    public void test() {
        FloodFill.Solution s = new FloodFill.Solution();

        assertDoubleArrayEquals(
                new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}},
                s.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)
        );

        assertDoubleArrayEquals(
                new int[][]{{1}},
                s.floodFill(new int[][]{{2}}, 0, 0, 1)
        );

        assertDoubleArrayEquals(
                new int[][]{{0, 0, 0}, {0, 1, 1}},
                s.floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1)
        );
    }

    private void assertDoubleArrayEquals(int[][] expected, int[][] actual) {
        assertEquals(expected.length, actual.length);
        assertEquals(expected[0].length, actual[0].length);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int[][] map = new int[image.length][image[0].length];
            List<Integer[]> queue = new ArrayList<>();
            queue.add(new Integer[]{sr, sc});

            int originalColor = image[sr][sc];
            while (queue.size() > 0) {
                int r = queue.get(0)[0];
                int c = queue.get(0)[1];
                map[r][c] = 1;
                queue.remove(0);

                image[r][c] = newColor;

                if (r + 1 < image.length && image[r + 1][c] == originalColor && map[r + 1][c] == 0) {
                    queue.add(new Integer[]{r + 1, c});
                }
                if (c + 1 < image[0].length && image[r][c + 1] == originalColor && map[r][c + 1] == 0) {
                    queue.add(new Integer[]{r, c + 1});
                }
                if (r - 1 >= 0 && image[r - 1][c] == originalColor && map[r - 1][c] == 0) {
                    queue.add(new Integer[]{r - 1, c});
                }
                if (c - 1 >= 0 && image[r][c - 1] == originalColor && map[r][c - 1] == 0) {
                    queue.add(new Integer[]{r, c - 1});
                }
            }
            return image;
        }
    }
}
