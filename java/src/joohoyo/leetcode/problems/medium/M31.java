package joohoyo.leetcode.problems.medium;

// 31. Next Permutation
// https://leetcode.com/problems/next-permutation/
// 16:00 ~ (min)


import java.util.Arrays;

public class M31 {
    public static void main(String[] args) {
        new M31().test();
    }

    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    public void test() {
        M31.Solution s = new M31.Solution();

//        int[] nums = new int[]{1,1,1}; // 1,1,1
//        int[] nums = new int[]{3,2,1}; // 1,2,3
//        int[] nums = new int[]{1,2,3}; // 1,3,2
//        int[] nums = new int[]{1,1,5}; // 1,5,1
//        int[] nums = new int[]{1,2,4,3}; // 1,3,2,4
//        int[] nums = new int[]{1,5,1};
        int[] nums = new int[]{2, 2, 7, 5, 4, 3, 2, 2, 1}; // 2,3,1,2,2,2,4,5,7
        s.nextPermutation(nums);
        print(nums);
//        s.nextPermutation(new int[]{1,2,4,3}); // 1,3,2,4


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
