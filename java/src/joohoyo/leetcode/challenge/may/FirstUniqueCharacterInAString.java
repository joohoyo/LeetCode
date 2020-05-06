package joohoyo.leetcode.challenge.may;

// First Unique Character in a String
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
// 16:33 ~ 16:41 (8min)

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqueCharacterInAString {
    @Test
    public void test() {
        FirstUniqueCharacterInAString.Solution s = new FirstUniqueCharacterInAString.Solution();

        assertEquals(0, s.firstUniqChar("a"));
        assertEquals(-1, s.firstUniqChar("aaa"));
        assertEquals(0, s.firstUniqChar("leetcode"));
        assertEquals(2, s.firstUniqChar("loveleetcode"));
    }

    class Solution {
        public int firstUniqChar(String s) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                String c = s.substring(i, i + 1);
                if (map.containsKey(c) == false) {
                    map.put(c, i);
                } else {
                    map.put(c, -1);
                }
            }

            int answer = -1;
            for (String key : map.keySet()) {
                if (map.get(key) == -1) {
                    continue;
                }
                if (answer == -1) {
                    answer = map.get(key);
                } else {
                    answer = Math.min(answer, map.get(key));
                }
            }
            return answer;
        }
    }
}
