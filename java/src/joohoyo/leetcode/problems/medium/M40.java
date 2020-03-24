package joohoyo.leetcode.problems.medium;

// 40. Combination Sum II
// https://leetcode.com/problems/combination-sum-ii/
// 10:20 ~ 10:48 (28min)

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class M40 {
    @Test
    public void test() {
        M40.Solution s = new M40.Solution();

        List<List<Integer>> l1 = Arrays.asList(Arrays.asList(1, 7), Arrays.asList(1, 2, 5), Arrays.asList(2, 6), Arrays.asList(1, 1, 6));
        List<List<Integer>> a1 = s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        assertListEquals(l1, a1);

        List<List<Integer>> l2 = Arrays.asList(Arrays.asList(1, 2, 2), Arrays.asList(5));
        List<List<Integer>> a2 = s.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        assertListEquals(l2, a2);
    }

    private void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        expected.stream().forEach(e -> {
            assertTrue(actual.stream().anyMatch(item -> item.equals(e)));
        });
    }

    class Solution {
        Set<List<Integer>> answerSet;

        private void combination(int[] candidates, int pos, List<Integer> combination, int sum, int target) {
            if (sum == target) {
                answerSet.add(new ArrayList<>(combination));
                return;
            }
            for (int i = pos; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                    combination.add(candidates[i]);

                    combination(
                            candidates,
                            i + 1,
                            combination,
                            sum + candidates[i],
                            target
                    );
                    combination.remove(combination.size() - 1);
                } else {
                    break;
                }
            }
        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            answerSet = new HashSet<>();
            Arrays.sort(candidates);
            for (int i = 0; i < candidates.length; i++) {
                if (i > 0 && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                List<Integer> combination = new ArrayList<>();
                combination.add(candidates[i]);
                combination(candidates, i + 1, combination, candidates[i], target);
            }
            return answerSet.stream().collect(Collectors.toList());
        }
    }
}