package joohoyo.leetcode.contest;

// 5367. Longest Happy Prefix
// https://leetcode.com/contest/weekly-contest-181/problems/longest-happy-prefix/
// 12:35 ~  gg (min)
// time limit

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C181_5367 {
    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals("aaaaaaaaaaaaa", s.longestPrefix("aaaaaaaaaaaaaa"));
        assertEquals("abab", s.longestPrefix("ababab"));
        assertEquals("leet", s.longestPrefix("leetcodeleet"));
        assertEquals("", s.longestPrefix("a"));
        assertEquals("l", s.longestPrefix("level"));
        assertEquals("aaaaaaaaaaaaa", s.longestPrefix("aaaaaaaaaaaaaa"));
    }

    class Solution {
        public String longestPrefix(String s) {
            if (s.length() <= 1) {
                return "";
            }

            String answer = "";
            String first = s.substring(0, 1);
            int fromIndex = 1;
            while (true) {
                int position = s.indexOf(first, fromIndex);
                if (position == -1) {
                    break;
                }
                fromIndex = position + 1;

                String suffix = s.substring(position);
                String prefix = s.substring(0, s.length() - position);
                if (suffix.equals(prefix)) {
                    if (answer.length() < prefix.length()) {
                        answer = prefix;
                    } else {
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
