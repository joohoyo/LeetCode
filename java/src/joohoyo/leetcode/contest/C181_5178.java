package joohoyo.leetcode.contest;

// 5178. Four Divisors
// https://leetcode.com/contest/weekly-contest-181/problems/four-divisors/
// 11:43 ~ 11:54 (11min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class C181_5178 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals(32, s.sumFourDivisors(new int[]{21, 4, 7}));
        Assertions.assertEquals(64, s.sumFourDivisors(new int[]{21, 21}));
    }

    class Solution {
        public int sumFourDivisors(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                Set<Integer> s = new HashSet<>();
                s.add(1);
                s.add(nums[i]);
                for (int j = 2; j <= Math.sqrt(nums[i]); j++) {
                    if (nums[i] % j == 0) {
                        s.add(j);
                        s.add(nums[i] / j);
                        if (s.size() > 4) {
                            break;
                        }
                    }
                }
                if (s.size() == 4) {
                    sum += s.stream().reduce((a, b) -> a + b).get();
                }
            }
            return sum;
        }
    }
}
