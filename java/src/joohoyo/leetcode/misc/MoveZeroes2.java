package joohoyo.leetcode.misc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroes2 {
    @Test
    public void test() {
        MoveZeroes2.Solution s = new MoveZeroes2.Solution();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        s.moveZeroes2(nums);
        assertArrayEquals(
                new int[]{1, 3, 12, 0, 0},
                nums
        );
    }

    class Solution {
        public void moveZeroes2(int[] nums) {
            for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
                if (nums[cur] != 0) {
                    int temp = nums[cur];
                    nums[cur] = nums[lastNonZeroFoundAt];
                    nums[lastNonZeroFoundAt] = temp;
                    lastNonZeroFoundAt++;
                }
            }
        }
    }
}
