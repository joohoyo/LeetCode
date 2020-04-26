package joohoyo.leetcode.contest;

// 5393. Maximum Points You Can Obtain from Cards
// https://leetcode.com/contest/weekly-contest-186/problems/maximum-points-you-can-obtain-from-cards/
// medium
// 11:44 ~ 12:12 (28min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C186_5393 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals(9, s.maxScore(new int[]{1, 5, 3, 4, 1, 6, 1}, 3));
        Assertions.assertEquals(12, s.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        Assertions.assertEquals(4, s.maxScore(new int[]{2, 2, 2}, 2));
        Assertions.assertEquals(55, s.maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        Assertions.assertEquals(1, s.maxScore(new int[]{1, 1000, 1}, 1));
        Assertions.assertEquals(202, s.maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
        Assertions.assertEquals(248, s.maxScore(new int[]{100, 40, 17, 9, 73, 75}, 3));
    }

    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int left = 0;
            int right = cardPoints.length - 1;

            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += cardPoints[i];
            }

            int answer = sum;
            for (int i = 0; i < k; i++) {
                sum = sum - cardPoints[k - 1 - i] + cardPoints[cardPoints.length - 1 - i];
                answer = Math.max(answer, sum);
            }
            return answer;
        }
    }

//    class Solution {
//        public int maxScore(int[] cardPoints, int k) {
//            int left = 0;
//            int right = cardPoints.length - 1;
//            return func(cardPoints, k, 0, 0, cardPoints.length - 1, 0);
//        }
//
//        private int func(int[] cardPoints, int k, int sum, int left, int right, int nowK) {
//            if (nowK == k) {
//                return sum;
//            }
//            return Math.max(
//                    func(cardPoints, k, sum + cardPoints[left], left + 1, right, nowK + 1),
//                    func(cardPoints, k, sum + cardPoints[right], left, right - 1, nowK + 1)
//            );
//        }
//    }
}
