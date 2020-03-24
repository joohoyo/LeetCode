package joohoyo.leetcode.problems.medium;

// 16. 3Sum Closest
// https://leetcode.com/problems/3sum-closest/
// 9:40 ~ gg

import java.util.Arrays;

public class M16 {
    public static void main(String[] args) {
        new M16().test();
    }

    public void test() {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // 2
        System.out.println(s.threeSumClosest(new int[]{0, 1, 2}, 3)); // 3
        System.out.println(s.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82)); // 82
        System.out.println(s.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1)); // -2
        System.out.println(s.threeSumClosest(new int[]{6, -18, -20, -7, -15, 9, 18, 10, 1, -20, -17, -19, -3, -5, -19, 10, 6, -11, 1, -17, -15, 6, 17, -18, -3, 16, 19, -20, -3, -17, -15, -3, 12, 1, -9, 4, 1, 12, -2, 14, 4, -4, 19, -20, 6, 0, -19, 18, 14, 1, -15, -5, 14, 12, -4, 0, -10, 6, 6, -6, 20, -8, -6, 5, 0, 3, 10, 7, -2, 17, 20, 12, 19, -13, -1, 10, -1, 14, 0, 7, -3, 10, 14, 14, 11, 0, -4, -15, -8, 3, 2, -5, 9, 10, 16, -4, -3, -9, -8, -14, 10, 6, 2, -12, -7, -16, -6, 10}, -52));
        // -52
    }

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sum = nums[0] + nums[1] + nums[2];
            int closest = sum;

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        return sum;
                    }
                    if (Math.abs(target - sum) < Math.abs(target - closest)) {
                        closest = sum;
                    }
                }
            }
            return closest;
        }
    }
}


