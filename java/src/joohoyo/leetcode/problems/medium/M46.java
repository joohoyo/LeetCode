package joohoyo.leetcode.problems.medium;

// 46. Permutations
// https://leetcode.com/problems/permutations/
// 14:39 ~ 15:02 (23min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class M46 {
    @Test
    public void test() {
        M46.Solution s = new M46.Solution();

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
        boolean firstReady;
        private int[] array;

        public List<List<Integer>> permute(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> answers = new ArrayList<>();

            this.firstReady = false;
            this.array = nums;
            while (hasMore()) {
                int[] temp = getNext();

                List<Integer> perm = new ArrayList<>();
                for (int i = 0; i < temp.length; i++) {
                    perm.add(temp[i]);
                }
                answers.add(perm);
            }

            return answers;
        }

        public boolean hasMore() {
            boolean end = firstReady;
            for (int i = 1; i < array.length; i++) {
                end = end && array[i] < array[i - 1];
            }
            return !end;
        }

        public int[] getNext() {
            if (!firstReady) {
                firstReady = true;
                return array;
            }

            int temp;
            int j = array.length - 2;
            int k = array.length - 1;

            for (; array[j] > array[j + 1]; j--) ;
            for (; array[j] > array[k]; k--) ;

            temp = array[k];
            array[k] = array[j];
            array[j] = temp;

            int r = array.length - 1;
            int s = j + 1;

            while (r > s) {
                temp = array[s];
                array[s++] = array[r];
                array[r--] = temp;
            }

            return array;
        }

    }
}
