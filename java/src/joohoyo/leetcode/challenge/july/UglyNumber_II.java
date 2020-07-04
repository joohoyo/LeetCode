package joohoyo.leetcode.challenge.july;

// Ugly Number II
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/
// 17:07 ~ 17:37 (30mins)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UglyNumber_II {
    @Test
    public void test() {
        UglyNumber_II.Solution s = new UglyNumber_II.Solution();

        assertEquals(1, s.nthUglyNumber(1));
        assertEquals(4, s.nthUglyNumber(4));
        assertEquals(12, s.nthUglyNumber(10));
        assertEquals(536870912, s.nthUglyNumber(1407));
        assertEquals(1399680000, s.nthUglyNumber(1600));
    }

    class Solution {
        public int nthUglyNumber(int n) {
            List<Long> uglyNumbers = new ArrayList<>();

            TreeSet<Long> set = new TreeSet<>();
            set.add(1L);

            int[] ratio = new int[]{2, 3, 5};
            while (uglyNumbers.size() < n) {
                long item = set.first();
                uglyNumbers.add(item);
                set.remove(item);

                for (int i = 0; i < 3; i++) {
                    long target = item * ratio[i];
                    if (target > 0) {
                        set.add(target);
                    }
                }
            }

            return uglyNumbers.get(n - 1).intValue();
        }
    }
}
