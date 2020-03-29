package joohoyo.leetcode.problems.medium;

// 47. Permutations II
// https://leetcode.com/problems/permutations-ii/
// 14:47 ~ 15:04 (17min)

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class M47 {
    @Test
    public void test() {
        M47.Solution s = new M47.Solution();

        assertListEquals(
                Arrays.asList(
                        Arrays.asList()
                ),
                s.permuteUnique(new int[]{})
        );

        assertListEquals(
                Arrays.asList(
                        Arrays.asList(1)
                ),
                s.permuteUnique(new int[]{1})
        );

        assertListEquals(
                Arrays.asList(
                        Arrays.asList(1, 1, 2),
                        Arrays.asList(1, 2, 1),
                        Arrays.asList(2, 1, 1)
                ),
                s.permuteUnique(new int[]{1, 1, 2})
        );
    }

    private void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        expected.stream().forEach(e -> {
            assertTrue(actual.stream().anyMatch(item -> item.equals(e)));
        });
    }

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);

            Set<Integer> indexes = new HashSet<>();

            List<List<Integer>> answer = new ArrayList<>();
            permuteUnique(nums, indexes, answer, new ArrayList<>());

            return answer;
        }

        private void permuteUnique(int[] nums, Set<Integer> indexes, List<List<Integer>> answer, List<Integer> list) {
            if (list.size() == nums.length) {
                if (!answer.contains(list)) {
                    answer.add(new ArrayList<>(list));
                }
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (indexes.contains(i)) {
                    continue;
                }

                list.add(nums[i]);
                indexes.add(i);
                permuteUnique(nums, indexes, answer, list);
                indexes.remove(i);
                list.remove(list.size() - 1);
            }
        }
    }
}
