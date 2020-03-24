package joohoyo.leetcode.problems.medium;

// 18. 4Sum
// https://leetcode.com/problems/4sum/
// 17:20 ~ 17:44 (22min)

import java.util.*;

public class M18 {
    public static void main(String[] args) {
        new M18().test();
    }

    public void test() {
        M18.Solution s = new M18.Solution();
//        System.out.println(s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
        System.out.println(s.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
        // [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    }

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> answer = new ArrayList<>();
            if (nums.length < 4) {
                return answer;
            }
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum > target) {
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                        }
                    }
                }
            }
            for (List<Integer> l : set) {
                answer.add(l);
            }
            return answer;
        }
    }

}
