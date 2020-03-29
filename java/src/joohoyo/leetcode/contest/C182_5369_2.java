package joohoyo.leetcode.contest;

// 5369. Count Number of Teams
// https://leetcode.com/contest/weekly-contest-182/problems/count-number-of-teams/
// 11:37 ~ 11:55 (18min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C182_5369_2 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals(0, s.numTeams(new int[]{}));
        Assertions.assertEquals(3, s.numTeams(new int[]{2, 5, 3, 4, 1}));
        Assertions.assertEquals(0, s.numTeams(new int[]{2, 1, 3}));
        Assertions.assertEquals(4, s.numTeams(new int[]{1, 2, 3, 4}));
    }

    class Solution {
        public int numTeams(int[] rating) {
            if (rating.length < 3) {
                return 0;
            }

            int answer = 0;
            int i = 0;
            int j = i + 1;
            int k = j + 1;
            while (true) {
                if (k == rating.length) {
                    j++;
                    k = j + 1;
                }
                if (j == rating.length - 1) {
                    i++;
                    j = i + 1;
                    k = j + 1;
                }
                if (i == rating.length - 2) {
                    break;
                }
                if ((rating[i] > rating[j] && rating[j] > rating[k]) || (rating[i] < rating[j] && rating[j] < rating[k])) {
                    answer++;
                }
                k++;
            }

            return answer;
        }
    }
}
