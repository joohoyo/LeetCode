package joohoyo.leetcode.challenge.june;

// Sort Colors
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
// 11:00 ~ 11:10 (10mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortColors {
    @Test
    public void test() {
        SortColors.Solution s = new SortColors.Solution();

        int[] colors = new int[]{2, 0, 2, 1, 1, 0};
        s.sortColors(colors);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, colors);

    }

    class Solution {
        public void sortColors(int[] nums) {
            int[] counts = new int[3];
            for (int n : nums) {
                counts[n]++;
            }

            int index = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    nums[index++] = i;
                }
            }
        }
    }
}
