package joohoyo.leetcode.challenge.may;

// Find All Anagrams in a String
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
// 14:42 ~ 15:06 (24min)

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllAnagramsInAString {
    @Test
    public void test() {
        FindAllAnagramsInAString.Solution s = new FindAllAnagramsInAString.Solution();

        assertListEquals(
                Arrays.asList(0, 6),
                s.findAnagrams("cbaebabacd", "abc")
        );
        assertListEquals(
                Arrays.asList(0, 1, 2),
                s.findAnagrams("abab", "ab")
        );
        assertListEquals(
                Arrays.asList(0),
                s.findAnagrams("ab", "ab")
        );
    }

    private void assertListEquals(List<Integer> expected, List<Integer> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            if (s.length() < p.length()) {
                return new ArrayList<>();
            }

            Map<Character, Integer> counter = new HashMap<>();
            for (char c : p.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }

            List<Integer> answer = new ArrayList<>();
            Map<Character, Integer> compare = new HashMap<>();
            List<Character> queue = new ArrayList<>();
            int index = 0;
            for (char c : s.toCharArray()) {
                compare.put(c, compare.getOrDefault(c, 0) + 1);
                queue.add(c);
                if (queue.size() > p.length()) {
                    Character removed = queue.remove(0);
                    compare.put(removed, compare.get(removed) - 1);
                    if (compare.get(removed) == 0) {
                        compare.remove(removed);
                    }
                }

                if (counter.equals(compare)) {
                    answer.add(index - p.length() + 1);
                }
                index++;
            }

            return answer;
        }
    }
}
