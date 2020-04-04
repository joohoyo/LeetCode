package joohoyo.leetcode.challenge._30day;

// Move Zeroes
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/
// 17:47 ~ 18:14 (27min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroes {
    @Test
    public void test() {
        MoveZeroes.Solution s = new MoveZeroes.Solution();

        int[] nums = new int[]{0, 0, 0, 1};
        s.moveZeroes(nums);
        assertArrayEquals(
                new int[]{1, 0, 0, 0},
                nums
        );

        nums = new int[]{1};
        s.moveZeroes(nums);
        assertArrayEquals(
                new int[]{1},
                nums
        );

        nums = new int[]{};
        s.moveZeroes(nums);
        assertArrayEquals(
                new int[]{},
                nums
        );

        nums = new int[]{0};
        s.moveZeroes(nums);
        assertArrayEquals(
                new int[]{0},
                nums
        );

        nums = new int[]{1, 2, 3};
        s.moveZeroes(nums);
        assertArrayEquals(
                new int[]{1, 2, 3},
                nums
        );


        nums = new int[]{0, 1, 0, 3, 12};
        s.moveZeroes(nums);
        assertArrayEquals(
                new int[]{1, 3, 12, 0, 0},
                nums
        );
    }

    class Solution {
        public void moveZeroes(int[] nums) {
            int zeroPosition = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroPosition = i;
                } else {
                    continue;
                }

                int numPosition = i;
                for (; numPosition < nums.length && nums[numPosition] == 0; numPosition++) ;
                if (numPosition == nums.length) {
                    break;
                }
                if (numPosition == i) {
                    continue;
                }

                int temp = nums[zeroPosition];
                nums[zeroPosition] = nums[numPosition];
                nums[numPosition] = temp;
            }
        }
    }
}
