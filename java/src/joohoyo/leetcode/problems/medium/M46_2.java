package joohoyo.leetcode.problems.medium;

// 46. Permutations
// https://leetcode.com/problems/permutations/
// 14:39 ~ 15:02 (23min)
// test

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class M46_2 {
    @Test
    public void test() {
        M46_2.Solution s = new M46_2.Solution();

        assertListEquals(
                Arrays.asList(
                        Arrays.asList()
                ),
                s.permute(new int[]{})
        );

        assertListEquals(
                Arrays.asList(
                        Arrays.asList(1)
                ),
                s.permute(new int[]{1})
        );

        assertListEquals(
                Arrays.asList(
                        Arrays.asList(0, -1, 1),
                        Arrays.asList(0, 1, -1),
                        Arrays.asList(-1, 0, 1),
                        Arrays.asList(-1, 1, 0),
                        Arrays.asList(1, 0, -1),
                        Arrays.asList(1, -1, 0)
                ),
                s.permute(new int[]{0, -1, 1})
        );

        assertListEquals(
                Arrays.asList(
                        Arrays.asList(1, 2, 4),
                        Arrays.asList(1, 4, 2),
                        Arrays.asList(2, 1, 4),
                        Arrays.asList(2, 4, 1),
                        Arrays.asList(4, 1, 2),
                        Arrays.asList(4, 2, 1)
                ),
                s.permute(new int[]{1, 2, 4})
        );
    }

    private void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        expected.stream().forEach(e -> {
            assertTrue(actual.stream().anyMatch(item -> item.equals(e)));
        });
    }

    class Solution {

        List<List<Integer>> answer;

        public List<List<Integer>> permute(int[] nums) {
            this.answer = new ArrayList<>();
            permute(new ArrayList<>(), new HashSet<>(), nums);
            return answer;
        }

        private void permute(List<Integer> p, Set<Integer> s, int[] nums) {
            if (p.size() == nums.length) {
                answer.add(new ArrayList<>(p));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (s.contains(nums[i])) {
                    continue;
                }
                p.add(nums[i]);
                s.add(nums[i]);
                permute(p, s, nums);
                p.remove(p.size() - 1);
                s.remove(nums[i]);
            }
        }

    }
}
