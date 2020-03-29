package joohoyo.leetcode.contest;

// 5371. Find All Good Strings
// https://leetcode.com/contest/weekly-contest-182/problems/find-all-good-strings/
// 12:19 ~ gg (min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C182_5371 {
    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(51, s.findGoodStrings(2, "aa", "da", "b"));
    }
    
    class Solution {
        public int findGoodStrings(int n, String s1, String s2, String evil) {
            int answer = 0;
            return answer;
        }
    }
}
