package joohoyo.leetcode.challenge.may;

// May LeetCoding Challenge - 19

// Permutation in String
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
// 21:58 ~ 22:08 (10min)

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermutationInString {
    @Test
    public void test() {
        PermutationInString.Solution s = new PermutationInString.Solution();

        assertEquals(true, s.checkInclusion("ab", "eidbaooo"));
        assertEquals(false, s.checkInclusion("ab", "eidboaoo"));
        assertEquals(true, s.checkInclusion("adc", "dcda"));

    }

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) {
                return false;
            }

            Map<Character, Integer> s1Map = new HashMap<>();
            for (char c : s1.toCharArray()) {
                s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> s2Map = new HashMap<>();
            for (int i = 0; i < s2.length(); i++) {
                s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
                if (i >= s1.length()) {
                    char c = s2.charAt(i - s1.length());
                    s2Map.put(c, s2Map.get(c) - 1);
                    if (s2Map.get(c) == 0) {
                        s2Map.remove(c);
                    }
                }

                if (s1Map.equals(s2Map)) {
                    return true;
                }
            }
            return false;
        }
    }
}
