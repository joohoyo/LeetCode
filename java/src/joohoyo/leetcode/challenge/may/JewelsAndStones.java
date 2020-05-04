package joohoyo.leetcode.challenge.may;

// Jewels and Stones
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/
// 14:30 ~ 14:35 (5min)

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JewelsAndStones {
    @Test
    public void test() {
        JewelsAndStones.Solution s = new JewelsAndStones.Solution();

        assertEquals(0, s.numJewelsInStones("", ""));
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
        assertEquals(0, s.numJewelsInStones("z", "ZZ"));
    }

    class Solution {
        public int numJewelsInStones(String J, String S) {
            int answer = 0;
            Set<String> jewels = new HashSet<>();
            for (int i = 0; i < J.length(); i++) {
                jewels.add(J.substring(i, i + 1));
            }

            for (int i = 0; i < S.length(); i++) {
                if (jewels.contains(S.substring(i, i + 1))) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
