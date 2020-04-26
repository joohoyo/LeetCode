package joohoyo.leetcode.contest;

// 5392. Maximum Score After Splitting a String
// https://leetcode.com/contest/weekly-contest-186/problems/maximum-score-after-splitting-a-string/
// easy
// 11:31 ~ 11:43 (12min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C186_5392 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals(5, s.maxScore("011101"));
        Assertions.assertEquals(5, s.maxScore("00111"));
        Assertions.assertEquals(3, s.maxScore("1111"));
        Assertions.assertEquals(3, s.maxScore("0000"));
        Assertions.assertEquals(1, s.maxScore("00"));
    }

    class Solution {
        public int maxScore(String s) {
            int answer = 0;

            int zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                zeros += s.substring(i, i + 1).equals("0") ? 1 : 0;
            }

            int ones = s.length() - zeros;
            int leftZeros = s.substring(0, 1).equals("0") ? 1 : 0;
            for (int i = 1; i < s.length(); i++) {
                int rightOnes = s.length() - i - (zeros - leftZeros);
                answer = Math.max(answer, leftZeros + rightOnes);
                leftZeros += s.substring(i, i + 1).equals("0") ? 1 : 0;

            }
            return answer;
        }
    }
}
