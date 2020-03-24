package joohoyo.leetcode.problems.medium;

// 39. Combination Sum
// https://leetcode.com/problems/combination-sum/
// 15:42 ~ 16:15 (33min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class M39 {
    @Test
    public void test() {
        M39.Solution s = new M39.Solution();

        assertListEquals(
                Arrays.asList(Arrays.asList(7), Arrays.asList(2, 2, 3)),
                s.combinationSum(new int[]{2, 3, 6, 7}, 7)
        );

        assertListEquals(
                Arrays.asList(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5)),
                s.combinationSum(new int[]{2, 3, 5}, 8)
        );
    }

    private void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        expected.stream().forEach(e -> {
            assertTrue(actual.stream().anyMatch(item -> item.equals(e)));
        });
    }

    class Solution {
        List<List<Integer>> answers;

        private void combination(List<Integer> candidatesList, List<Integer> combination, int sum, int target) {
            if (sum == target) {
                answers.add(combination.stream().collect(Collectors.toList()));
                return;
            }
            for (int i = 0; i < candidatesList.size(); i++) {
                if (sum + candidatesList.get(i) <= target) {
                    combination.add(candidatesList.get(i));

                    combination(
                            IntStream.range(i, candidatesList.size()).boxed()
                                    .map(j -> candidatesList.get(j))
                                    .collect(Collectors.toList()),
                            combination,
                            sum + candidatesList.get(i),
                            target
                    );
                    combination.remove(combination.size() - 1);
                } else {
                    break;
                }
            }
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            answers = new ArrayList<>();
            Arrays.sort(candidates);
            List<Integer> candidatesList = IntStream.range(0, candidates.length).boxed().map(j -> candidates[j]).collect(Collectors.toList());
            combination(candidatesList, new ArrayList<>(), 0, target);
            return answers;
        }
    }
}