package joohoyo.leetcode.contest;

// 5364. Create Target Array in the Given Order
// https://leetcode.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
// 11:31 ~ 11:43 (12min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class C181_5364 {
    @Test
    public void test() {
        Solution s = new Solution();

        assertArrayEquals(new int[]{1}, s.createTargetArray(new int[]{1}, new int[]{0}));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, s.createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0}));
        assertArrayEquals(new int[]{0, 4, 1, 3, 2}, s.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1}));
    }

    class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                array.add(index[i], nums[i]);
            }
            int[] answer = new int[array.size()];
            for (int i = 0; i < array.size(); i++) {
                answer[i] = array.get(i);
            }
            return answer;
        }
    }

}
