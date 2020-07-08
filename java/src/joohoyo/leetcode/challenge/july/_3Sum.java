package joohoyo.leetcode.challenge.july;

// 3Sum
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3384/
// 16:50 ~ 17:50 (60mins)

import joohoyo.leetcode.helper.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    @Test
    public void test() {
        joohoyo.leetcode.challenge.july._3Sum.Solution s = new joohoyo.leetcode.challenge.july._3Sum.Solution();

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, 0, 1));
        expected.add(Arrays.asList(-1, -1, 2));

        Assertions.assertDoubleListEquals(expected, s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    @Test
    public void test2() {
        joohoyo.leetcode.challenge.july._3Sum.Solution s = new joohoyo.leetcode.challenge.july._3Sum.Solution();

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-2, 0, 2));

        Assertions.assertDoubleListEquals(expected, s.threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                find(result, nums, i);
            }
            return result;
        }

        private void find(List<List<Integer>> result, int[] nums, int index) {
            int target = nums[index] * -1;
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right && left < nums.length && right >= 0) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    while (++left < nums.length && nums[left - 1] == nums[left]) ;
                } else if (sum > target) {
                    while (--right >= 0 && nums[right + 1] == nums[right]) ;
                } else {
                    result.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    while (++left < nums.length && nums[left - 1] == nums[left]) ;
                    while (--right >= 0 && nums[right + 1] == nums[right]) ;
                }
            }
        }
    }
}
