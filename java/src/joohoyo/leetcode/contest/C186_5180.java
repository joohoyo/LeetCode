package joohoyo.leetcode.contest;

// 5180. Constrained Subset Sum
// https://leetcode.com/contest/weekly-contest-186/problems/constrained-subset-sum/
// hard
// gg

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C186_5180 {
    @Test
    public void test1() {
        Solution s = new Solution();

        Assertions.assertEquals(37, s.constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
        Assertions.assertEquals(-1, s.constrainedSubsetSum(new int[]{-1, -2, -3}, 1));
        Assertions.assertEquals(23, s.constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));

    }

    class Solution {
        public int constrainedSubsetSum(int[] nums, int k) {
            return 1;
        }
    }
}
