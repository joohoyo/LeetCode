package joohoyo.leetcode.contest;

// 5195. Longest Happy String
// https://leetcode.com/contest/weekly-contest-183/problems/longest-happy-string/
// 12:03 ~ 12:50 (47min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C183_5195 {
    @Test
    public void test() {
        Solution s = new Solution();

        // 다양한 경우가 나올 수 있기 때문에 테스트코드 패스
        assertEquals("ccaccbcc", s.longestDiverseString(1, 1, 7));
//        assertEquals("ccbccbbccbbccbbccbc", s.longestDiverseString(0, 8, 11));
        assertEquals("ccaccbcc", s.longestDiverseString(1, 1, 7));
//        assertEquals("ccbccacc", s.longestDiverseString(1,1,7));
        assertEquals("aa", s.longestDiverseString(3, 0, 0));
        assertEquals("aabbc", s.longestDiverseString(2, 2, 1));
        assertEquals("aabaa", s.longestDiverseString(7, 1, 0));


    }

    class Solution {
        String answer = "";
        String[] str = {"a", "b", "c"};

        public String longestDiverseString(int a, int b, int c) {
            int[] nums = {a, b, c};
            backtracking(a + b + c, nums, -1, "");
            return this.answer;
        }

        private void backtracking(int maxLength, int[] nums, int beforeIndex, String current) {
            if (this.answer.length() == maxLength) {
                return;
            }

            int maxIndex = getMaxIndex(nums, beforeIndex);
            if (maxIndex == -1) {
                if (this.answer.length() < current.length()) {
                    this.answer = current;
                }
                return;
            }

            for (int i = 0; i < 2; i++) {
                int num = 2 - i;
                if (nums[maxIndex] < num) {
                    continue;
                }
                nums[maxIndex] -= num;
                backtracking(maxLength, nums, maxIndex, current + this.str[maxIndex].repeat(num));
                nums[maxIndex] += num;
            }
        }

        private int getMaxIndex(int[] nums, int beforeIndex) {
            int max = 0;
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                if (max < nums[i] && beforeIndex != i) {
                    max = nums[i];
                    index = i;
                }
            }
            return index;
        }
    }
}
