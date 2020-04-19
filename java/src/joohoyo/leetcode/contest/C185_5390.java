package joohoyo.leetcode.contest;

// 5390. Minimum Number of Frogs Croaking
// https://leetcode.com/contest/weekly-contest-185/problems/minimum-number-of-frogs-croaking/
// medium
// 12:26 ~ 12:53 (27min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class C185_5390 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals(1, s.minNumberOfFrogs("croakcroak"));
        Assertions.assertEquals(2, s.minNumberOfFrogs("crcoakroak"));
        Assertions.assertEquals(-1, s.minNumberOfFrogs("croakcrook"));
        Assertions.assertEquals(-1, s.minNumberOfFrogs("croakcroa"));
        Assertions.assertEquals(2, s.minNumberOfFrogs("ccroakcroakroak"));
    }

    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            int c = 0, r = 0, o = 0, a = 0;
            Map<Integer, Integer> frogPosition = new HashMap<>();
            int minPosition = 0;
            for (int i = 0; i < croakOfFrogs.length(); i++) {
                String sub = croakOfFrogs.substring(i, i + 1);
                if ("c".equals(sub)) {
                    c++;
                    frogPosition.put(Math.min(minPosition, frogPosition.size()), i);
                    minPosition++;
                } else if ("r".equals(sub)) {
                    if (c > 0 && c > r) {
                        r++;
                    } else {
                        return -1;
                    }
                } else if ("o".equals(sub)) {
                    if (c >= r && r > 0) {
                        o++;
                    } else {
                        return -1;
                    }
                } else if ("a".equals(sub)) {
                    if (c >= r && r >= o && o > 0) {
                        a++;
                    } else {
                        return -1;
                    }
                } else if ("k".equals(sub)) {
                    if (c >= r && r >= o && o >= a && a > 0) {
                        c--;
                        r--;
                        o--;
                        a--;
                        minPosition--;
                    }
                }
            }

            return (c + r + o + a == 0) ? frogPosition.size() : -1;
        }
    }
}
