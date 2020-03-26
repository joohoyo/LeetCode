package joohoyo.leetcode.problems.medium;

// 43. Multiply Strings
// https://leetcode.com/problems/multiply-strings/
// 16:33 ~ 17:30 (57min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M43 {
    @Test
    public void test() {
        M43.Solution s = new M43.Solution();

        assertEquals("0", s.multiply("2", "0"));
        assertEquals("56088", s.multiply("123", "456"));
        assertEquals("998001", s.multiply("999", "999"));
        assertEquals("121932631112635269", s.multiply("123456789", "987654321"));
        assertEquals("53746843983", s.multiply("881095803", "61"));
    }

    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }

            List<String> numbers = new ArrayList<>();
            for (int i = num2.length() - 1; i >= 0; i--) {
                numbers.add(mul(num1, num2.substring(i, i + 1)) + "0".repeat(num2.length() - i - 1));
            }

            String answer = "";
            for (String number : numbers) {
                answer = sum(number, answer);
            }

            return answer;
        }

        private String mul(String a, String b) { // b length == 1
            if ("0".equals(b)) {
                return "0";
            }

            String answer = a;
            for (int i = 1; i < Integer.parseInt(b); i++) {
                answer = sum(answer, a);
            }

            return answer;
        }

        private String sum(String a, String b) {
            String answer = "";
            String s1 = reverse(a.length() > b.length() ? a : b);
            String s2 = reverse(a.length() > b.length() ? b : a);
            int carrier = 0;
            for (int i = 0; i < Math.max(s1.length(), s2.length()); i++) {
                int n1 = Integer.parseInt(s1.substring(i, i + 1));
                int n2 = 0;
                if (i < s2.length()) {
                    n2 = Integer.parseInt(s2.substring(i, i + 1));
                }

                int sum = n1 + n2 + carrier;
                if (sum >= 10) {
                    carrier = 1;
                    sum -= 10;
                } else {
                    carrier = 0;
                }

                answer += sum;
            }
            if (carrier == 1) {
                answer += "1";
            }
            answer = reverse(answer);
            return answer;
        }

        private String reverse(String str) {
            if (str.isEmpty()) {
                return "";
            }
            String ret = "";
            for (int i = 0; i < str.length(); i++) {
                ret += str.substring(str.length() - i - 1, str.length() - i);
            }
            return ret;
        }
    }
}
