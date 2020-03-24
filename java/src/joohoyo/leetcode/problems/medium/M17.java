package joohoyo.leetcode.problems.medium;

// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// 16:43 ~ 17:00 (17min)

import java.util.*;

public class M17 {
    public static void main(String[] args) {
        new M17().test();
    }

    public void test() {
        M17.Solution s = new M17.Solution();
        System.out.println(s.letterCombinations("")); // ""
        System.out.println(s.letterCombinations("2")); // ["a", "b", "c"]
        System.out.println(s.letterCombinations("23")); // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        System.out.println(s.letterCombinations("22"));

    }

    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return new ArrayList<>();
            }

            Map<String, List<String>> letters = new HashMap<>();
            letters.put("2", Arrays.asList("a", "b", "c"));
            letters.put("3", Arrays.asList("d", "e", "f"));
            letters.put("4", Arrays.asList("g", "h", "i"));
            letters.put("5", Arrays.asList("j", "k", "l"));
            letters.put("6", Arrays.asList("m", "n", "o"));
            letters.put("7", Arrays.asList("p", "q", "r", "s"));
            letters.put("8", Arrays.asList("t", "u", "v"));
            letters.put("9", Arrays.asList("w", "x", "y", "z"));

            List<String> answer = letters.get(digits.substring(0, 1));
            for (int i = 1; i < digits.length(); i++) {
                List<String> store = new ArrayList<>();
                for (String c : answer) {
                    for (String l : letters.get(digits.substring(i, i + 1))) {
                        store.add(c + l);
                    }
                }
                answer = store;
            }
            return answer;
        }
    }

}
