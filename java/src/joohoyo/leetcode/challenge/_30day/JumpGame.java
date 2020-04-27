package joohoyo.leetcode.challenge._30day;

// Jump Game
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/
// 14:38 ~ 14:49 (11min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGame {
    @Test
    public void test() {
        JumpGame.Solution s = new JumpGame.Solution();

        assertEquals(true, s.canJump(new int[]{0}));
        assertEquals(false, s.canJump(new int[]{0, 2, 3}));
        assertEquals(true, s.canJump(new int[]{2, 3, 1, 1, 4}));
        assertEquals(false, s.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 0) {
                return false;
            }

            int[] steps = new int[nums.length];
            steps[0] = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j >= nums.length) {
                        continue;
                    }
                    if (steps[i] == 0) {
                        continue;
                    }
                    if (i + j == nums.length - 1) {
                        return true;
                    }
                    steps[i + j]++;
                }
            }
            return steps[nums.length - 1] > 0;
        }
    }
}
