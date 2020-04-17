package joohoyo.leetcode.challenge._30day;

// Valid Parenthesis String
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3301/
// 16:13 ~ gg (min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidParenthesisString {
    @Test
    public void test() {
        ValidParenthesisString.Solution s = new ValidParenthesisString.Solution();

        assertEquals(true, s.checkValidString(""));
        assertEquals(true, s.checkValidString("*"));
        assertEquals(true, s.checkValidString("()"));
        assertEquals(false, s.checkValidString("())"));
        assertEquals(false, s.checkValidString("(()"));
        assertEquals(true, s.checkValidString("(*)"));
        assertEquals(true, s.checkValidString("(*))"));
        assertEquals(true, s.checkValidString("((*)"));
        assertEquals(true, s.checkValidString("(((******))"));
        assertEquals(false, s.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }

    class Solution {
        public boolean checkValidString(String s) {
            int min = 0;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                String c = s.substring(i, i + 1);
                if ("(".equals(c)) {
                    min++;
                    max++;
                } else if (")".equals(c)) {
                    min = Math.max(min - 1, 0);
                    max--;
                } else {
                    min = Math.max(min - 1, 0);
                    max++;
                }
                if (max < 0) {
                    return false;
                }
            }
            return min == 0;
        }
    }
}
