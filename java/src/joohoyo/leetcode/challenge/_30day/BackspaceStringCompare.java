package joohoyo.leetcode.challenge._30day;

// Backspace String Compare
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
// 10:13 ~ 10:27 (14min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BackspaceStringCompare {
    @Test
    public void test() {
        BackspaceStringCompare.Solution s = new BackspaceStringCompare.Solution();

        Assertions.assertTrue(s.backspaceCompare("ab#c", "ad#c"));
        Assertions.assertTrue(s.backspaceCompare("ab##", "c#d#"));
        Assertions.assertTrue(s.backspaceCompare("a##c", "#a#c"));
        Assertions.assertFalse(s.backspaceCompare("a#c", "b"));
        Assertions.assertTrue(s.backspaceCompare("#c", "c"));
        Assertions.assertFalse(s.backspaceCompare("#c#", "c"));

    }

    class Solution {
        public boolean backspaceCompare(String S, String T) {
            S = getEditorString(S);
            T = getEditorString(T);
            return S.equals(T);
        }

        private String getEditorString(String K) {
            int index = 0;
            while (index < K.length()) {
                if ("#".charAt(0) == K.charAt(index)) {
                    K = K.substring(0, Math.max(index - 1, 0)) + K.substring(Math.min(index + 1, K.length()));
                    index = Math.max(index - 2, -1);
                }
                index++;
            }
            return K;
        }
    }
}
