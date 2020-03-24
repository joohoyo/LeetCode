package joohoyo.leetcode.problems.medium;

// 31. Next Permutation
// https://leetcode.com/problems/next-permutation/
// 16:00 ~ (min)

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class M31_2 {
    @Test
    @DisplayName("다음 순열을 맞춰라")
    public void test() {
        M31_2.Solution s = new M31_2.Solution();

        int[] exp = new int[]{1, 3, 2};
        int[] nums = new int[]{1, 2, 3};
        s.nextPermutation(nums);
        assertArrayEquals(exp, nums);
    }

    class Solution {
        public void nextPermutation(int[] nums) {
            boolean end = true;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] < nums[i]) {
                    end = false;
                }
            }
            if (end) {
                Arrays.sort(nums);
                return;
            }

            int left = nums.length - 2;
            int right = nums.length - 1;
            for (; nums[left] >= nums[left + 1]; left--) ;
            for (; nums[left] >= nums[right]; right--) ;

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            int r = nums.length - 1;
            int l = left + 1;
            while (l < r) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
    }
}
