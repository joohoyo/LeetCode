package joohoyo.leetcode.challenge.may;

// Remove K Digits
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
// 11:28 ~ gg (min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveKDigits2 {
    @Test
    public void test() {
        RemoveKDigits2.Solution s = new RemoveKDigits2.Solution();

        assertEquals("1219", s.removeKdigits("1432219", 3));
        assertEquals("200", s.removeKdigits("10200", 1));
        assertEquals("0", s.removeKdigits("10", 2));
        assertEquals("11", s.removeKdigits("112", 1));
    }

    class Solution {
        public String removeKdigits(String num, int k) {
            List<Character> stack = new ArrayList<>();
            for (char c : num.toCharArray()) {
                while (true) {
                    if (stack.size() == 0 || k == 0) {
                        break;
                    }
                    if (stack.get(stack.size() - 1) <= c) {
                        break;
                    }
                    k--;
                    stack.remove(stack.size() - 1);
                }
                stack.add(c);
            }

            for (int i = 0; i < k; i++) {
                stack.remove(stack.size() - 1);
            }

            String answer = "";
            boolean hasLeedingZero = true;
            for (char c : stack) {
                if (hasLeedingZero && c == '0') {
                    continue;
                }
                hasLeedingZero = false;
                answer += c;
            }

            return "".equals(answer) ? "0" : answer;
        }
    }
}
