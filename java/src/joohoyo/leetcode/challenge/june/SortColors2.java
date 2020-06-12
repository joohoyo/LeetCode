package joohoyo.leetcode.challenge.june;

// Sort Colors
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
// 11:00 ~ 11:10 (10mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortColors2 {
    @Test
    public void test() {
        SortColors2.Solution s = new SortColors2.Solution();

        int[] colors = new int[]{2, 0, 2, 1, 1, 0};
        s.sortColors(colors);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, colors);

    }

    class Solution {
        public void sortColors(int[] nums) {
            int zeroPosition = 0;
            int twoPosition = nums.length - 1;
            int current = 0;
            int temp = 0;
            while (current <= twoPosition) {
                if (nums[current] == 2) {
                    temp = nums[current];
                    nums[current] = nums[twoPosition];
                    nums[twoPosition] = temp;
                    twoPosition--;
                } else if (nums[current] == 0) {
                    temp = nums[current];
                    nums[current] = nums[zeroPosition];
                    nums[zeroPosition] = temp;
                    zeroPosition++;
                    current++;
                } else {
                    current++;
                }
            }
        }
    }
}
