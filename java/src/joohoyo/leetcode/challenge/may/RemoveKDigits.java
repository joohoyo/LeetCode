package joohoyo.leetcode.challenge.may;

// Remove K Digits
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
// 11:28 ~ gg (min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveKDigits {
    @Test
    public void test() {
        RemoveKDigits.Solution s = new RemoveKDigits.Solution();

        assertEquals("1219", s.removeKdigits("1432219", 3));
        assertEquals("200", s.removeKdigits("10200", 1));
        assertEquals("0", s.removeKdigits("10", 2));

    }

    class Solution {
        public String removeKdigits(String num, int k) {
            if (num.length() == k) {
                return "0";
            }
            if (k == 0) {
                return num;
            }

            int min = Integer.MAX_VALUE;
            char[] numChar = num.toCharArray();
            for (int j = 0; j < num.length() - k; j++) {
                int[] check = new int[num.length() + 1];
                for (int i = j; i < j + k; i++) {
                    check[i] = 1;
                }

                for (int i = 0; i < k; i++) {
                    int head;
                    for (head = j + k - i - 1; head < num.length() - i; head++) {
                        min = Math.min(min, Integer.parseInt(getRemovedString(numChar, check)));
                        check[head] = 0;
                        check[head + 1] = 1;
                    }
                    check[head - 1] = 1;
                }
            }
            return String.valueOf(min);
        }

        private String getRemovedString(char[] num, int[] check) {
            String ret = "";
            for (int i = 0; i < num.length; i++) {
                if (check[i] == 0) {
                    ret += num[i];
                }
            }
            return ret;
        }
    }
}
