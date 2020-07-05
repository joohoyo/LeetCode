package joohoyo.leetcode.challenge.july;

// Hamming Distance
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
// 18:03 ~ 18:07 (4mins)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HammingDistance {
    @Test
    public void test() {
        HammingDistance.Solution s = new HammingDistance.Solution();

        Assertions.assertEquals(2, s.hammingDistance(1, 4));
    }

    class Solution {
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int count = 0;
            while (z > 0) {
                if (z % 2 == 1) {
                    count++;
                }
                z /= 2;
            }
            return count;
        }
    }
}
