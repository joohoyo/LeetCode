package joohoyo.leetcode.challenge._30day;

// Happy Number
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
// 16:19 ~ 16:30 (11min)

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HappyNumber {
    @Test
    public void test() {
        HappyNumber.Solution s = new HappyNumber.Solution();

        assertEquals(true, s.isHappy(19));
        assertEquals(false, s.isHappy(18));
    }

    class Solution {
        public boolean isHappy(int n) {
            boolean answer = true;

            Set<Integer> set = new HashSet<>();
            while (true) {
                if (n == 1) {
                    answer = true;
                    break;
                }
                if (set.contains(n)) {
                    answer = false;
                    break;
                }
                set.add(n);
                n = getSquareSum(n);
            }

            return answer;
        }

        private int getSquareSum(int n) {
            String s = String.valueOf(n);
            int r = 0;
            for (int i = 0; i < s.length(); i++) {
                int v = Integer.valueOf(s.substring(i, i + 1));
                r += v * v;
            }
            return r;
        }
    }
}
