package joohoyo.leetcode.contest;

// 5388. Reformat The String
// https://leetcode.com/contest/weekly-contest-185/problems/reformat-the-string/
// easy
// 11:46 ~ 12:03 (17min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;

public class C185_5388 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals("", s.reformat("leetcode"));
        Assertions.assertEquals("", s.reformat("1229857369"));
        assertThat(
                s.reformat("a0b1c2"),
                anyOf(is("0a1b2c"), is("a0b1c2"), is("2c1b0a"), is("c2b1a0"), is("0c2a1b"))
        );

//        Assertions.assertEquals("c2o0v1i9d", s.reformat("covid2019")); // 가능한 값이 너무 많음..

        assertThat(
                s.reformat("ab123"),
                anyOf(is("1a2b3"), is("3a2b1"), is("3b2a1"))
        );
    }

    class Solution {
        public String reformat(String s) {
            List<String> alphabets = new ArrayList<>();
            List<String> numbers = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                String c = s.substring(i, i + 1);
                if (c.matches("[a-z]")) {
                    alphabets.add(c);
                } else {
                    numbers.add(c);
                }
            }

            if (Math.abs(alphabets.size() - numbers.size()) >= 2) {
                return "";
            }

            boolean alphabetFirst = (alphabets.size() > numbers.size()) ? true : false;
            String answer = "";
            while (true) {
                if ((alphabetFirst == true && numbers.size() == 0) || (alphabetFirst == false && alphabets.size() == 0)) {
                    break;
                }
                answer += (alphabetFirst == true)
                        ? alphabets.remove(alphabets.size() - 1) + numbers.remove(numbers.size() - 1)
                        : numbers.remove(numbers.size() - 1) + alphabets.remove(alphabets.size() - 1);
            }
            if (alphabetFirst == true && alphabets.size() != 0) {
                answer += alphabets.remove(alphabets.size() - 1);
            } else if (alphabetFirst == false && numbers.size() != 0) {
                answer += numbers.remove(numbers.size() - 1);
            }

            return answer;
        }
    }
}
