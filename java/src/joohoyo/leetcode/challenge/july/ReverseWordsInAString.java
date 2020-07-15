package joohoyo.leetcode.challenge.july;

// Reverse Words in a String
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
// 18:32 ~ 18:34 (2mins)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseWordsInAString {
    @Test
    public void test() {
        ReverseWordsInAString.Solution s = new ReverseWordsInAString.Solution();

        Assertions.assertEquals("blue is sky the", s.reverseWords("the sky is blue"));
        Assertions.assertEquals("world! hello", s.reverseWords("  hello world!  "));
        Assertions.assertEquals("example good a", s.reverseWords("a good   example"));
    }

    class Solution {
        public String reverseWords(String s) {
            String[] splits = s.split(" +");
            StringBuffer result = new StringBuffer();
            for (int i = splits.length - 1; i >= 0; i--) {
                result.append(splits[i] + " ");
            }

            return result.toString().trim();
        }
    }
}
