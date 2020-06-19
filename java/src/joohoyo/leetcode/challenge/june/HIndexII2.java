package joohoyo.leetcode.challenge.june;

// H-Index II
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
// 11:29 ~ gg (mins)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HIndexII2 {
    @Test
    public void test() {
        HIndexII2.Solution s = new HIndexII2.Solution();

        assertEquals(3, s.hIndex(new int[]{0, 1, 3, 5, 6}));
        assertEquals(5, s.hIndex(new int[]{5, 5, 5, 5, 5}));
        assertEquals(1, s.hIndex(new int[]{1}));
        assertEquals(1, s.hIndex(new int[]{0, 1}));
        assertEquals(0, s.hIndex(new int[]{0, 0, 0, 0}));
        assertEquals(3, s.hIndex(new int[]{1, 4, 7, 9}));

    }

    class Solution {
        public int hIndex(int[] citations) {
            if (citations.length == 0 || citations[citations.length - 1] == 0) {
                return 0;
            }

            for (int hIndex = citations.length; hIndex > 0; hIndex--) {
                int bs = firstGreaterEqual(citations, hIndex);
                int atLeastCount = citations.length - bs;
                if (hIndex <= atLeastCount) {
                    return hIndex;
                }
            }
            return 0;

        }

        private int firstGreaterEqual(int[] A, int target) {
            int low = 0, high = A.length;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                if (A[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
