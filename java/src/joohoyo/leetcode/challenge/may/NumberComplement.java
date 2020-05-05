package joohoyo.leetcode.challenge.may;

// Number Complement
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
// 18:34 ~ 18:45 (11min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComplement {
    @Test
    public void test() {
        NumberComplement.Solution s = new NumberComplement.Solution();

        assertEquals(0, s.findComplement(1));
        assertEquals(2, s.findComplement(5));
        assertEquals(0, s.findComplement(Integer.MAX_VALUE));
        assertEquals(0, s.findComplement(7));
    }

    class Solution {
        public int findComplement(int num) {
            int answer = 1;
            int original = num;
            while (num > 1) {
                num = num >> 1;
                answer = (answer << 1) + 1;
            }
            return answer - original;
        }
    }
}
