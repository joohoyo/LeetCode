package joohoyo.leetcode.challenge.may;

// Ransom Note
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
// 22:12 ~ 22:17 (5min)

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RansomNote {
    @Test
    public void test() {

        RansomNote.Solution s = new RansomNote.Solution();

        assertEquals(true, s.canConstruct("", ""));
        assertEquals(false, s.canConstruct("a", ""));
        assertEquals(false, s.canConstruct("a", "b"));
        assertEquals(false, s.canConstruct("aa", "ab"));
        assertEquals(true, s.canConstruct("aa", "aab"));
    }

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < magazine.length(); i++) {
                String sub = magazine.substring(i, i + 1);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                String sub = ransomNote.substring(i, i + 1);
                if (map.containsKey(sub) == false || map.get(sub) == 0) {
                    return false;
                }
                map.put(sub, map.get(sub) - 1);
            }
            return true;
        }
    }
}
