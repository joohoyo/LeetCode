package joohoyo.leetcode.contest;

// 5369. Count Number of Teams
// https://leetcode.com/contest/weekly-contest-182/problems/count-number-of-teams/
// 11:37 ~  (min)
// Time Limit Exceeded

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class C182_5369 {
    @Test
    public void test() {
        Solution s = new Solution();

        Assertions.assertEquals(0, s.numTeams(new int[]{}));
        Assertions.assertEquals(3, s.numTeams(new int[]{2, 5, 3, 4, 1}));
        Assertions.assertEquals(0, s.numTeams(new int[]{2, 1, 3}));
        Assertions.assertEquals(4, s.numTeams(new int[]{1, 2, 3, 4}));
    }

    class Solution {
        private int answer;

        public int numTeams(int[] rating) {
            if (rating.length < 3) {
                return 0;
            }
            this.answer = 0;
            numTeams(rating, new ArrayList<Integer>(), new int[rating.length]);

            return this.answer;
        }

        private void numTeams(int[] rating, List<Integer> indexes, int[] used) {
            if (indexes.size() == 3) {
                int v1 = rating[indexes.get(0)];
                int v2 = rating[indexes.get(1)];
                int v3 = rating[indexes.get(2)];
                if (indexes.get(0) > indexes.get(1) || indexes.get(1) > indexes.get(2)) {
                    return;
                }
                if ((v1 > v2 && v2 > v3) || (v1 < v2 && v2 < v3)) {
                    this.answer++;
                }
                return;
            }
            for (int i = 0; i < rating.length; i++) {
                if (used[i] == 1) {
                    continue;
                }

                used[i] = 1;
                indexes.add(i);
                numTeams(rating, indexes, used);
                indexes.remove(indexes.size() - 1);
                used[i] = 0;
            }

        }
    }
}
