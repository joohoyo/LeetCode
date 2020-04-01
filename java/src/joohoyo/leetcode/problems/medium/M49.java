package joohoyo.leetcode.problems.medium;

// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/
// 15:11 ~ 15:27 (16min)

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class M49 {
    @Test
    public void test() {
        M49.Solution s = new M49.Solution();

        assertArrayListEquals(
                Arrays.asList(),
                s.groupAnagrams(new String[]{})
        );
        assertArrayListEquals(
                Arrays.asList(Arrays.asList("a")),
                s.groupAnagrams(new String[]{"a"})
        );
        assertArrayListEquals(
                Arrays.asList(Arrays.asList("tea", "ate", "eat"), Arrays.asList("nat", "tan"), Arrays.asList("bat")),
                s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})
        );
    }

    private void assertArrayListEquals(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.size(), actual.size());

        List<List<String>> copyOfActual = new ArrayList<>(actual);
        for (int i = 0; i < expected.size(); i++) {
            List<String> sortedExpected = expected.get(i).stream().sorted().collect(Collectors.toList());
            for (int j = 0; j < copyOfActual.size(); j++) {
                List<String> sortedActual = copyOfActual.get(j).stream().sorted().collect(Collectors.toList());
                if (sortedExpected.equals(sortedActual)) {
                    copyOfActual.remove(j);
                    break;
                }
            }
        }
        assertEquals(0, copyOfActual.size());
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> answers = new ArrayList<>();

            Map<String, List<String>> map = new HashMap();
            for (int i = 0; i < strs.length; i++) {
                final String s = strs[i];
                String key = IntStream.range(0, s.length()).boxed()
                        .map(j -> s.substring(j, j + 1))
                        .sorted()
                        .collect(Collectors.joining());
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(s);
            }

            for (String key : map.keySet()) {
                answers.add(map.get(key));
            }
            return answers;
        }
    }
}
