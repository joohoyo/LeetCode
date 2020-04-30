package joohoyo.leetcode.challenge._30day;

// First Unique Number
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
// 17:20 ~ 17:47 (27min)

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C_FirstUniqueNumber {
    @Test
    public void test1() {
        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        assertEquals(2, firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        assertEquals(2, firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        assertEquals(3, firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        assertEquals(-1, firstUnique.showFirstUnique()); // return -1
    }

    @Test
    public void test2() {
        FirstUnique firstUnique = new FirstUnique(new int[]{7, 7, 7, 7, 7, 7});
        assertEquals(-1, firstUnique.showFirstUnique()); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        assertEquals(17, firstUnique.showFirstUnique()); // return 17
    }

    @Test
    public void test3() {
        FirstUnique firstUnique = new FirstUnique(new int[]{809});
        assertEquals(809, firstUnique.showFirstUnique()); // return 809
        firstUnique.add(809);          // the queue is now [809,809]
        assertEquals(-1, firstUnique.showFirstUnique()); // return -1
    }

    @Test
    public void test4() {
        FirstUnique firstUnique = new FirstUnique(new int[]{233});
        assertEquals(233, firstUnique.showFirstUnique());
        firstUnique.add(11);
        assertEquals(233, firstUnique.showFirstUnique());
    }

    class FirstUnique {

        List<Integer> uniqList;
        Map<Integer, Integer> numbers;

        public FirstUnique(int[] nums) {
            this.uniqList = new ArrayList<>();
            this.numbers = new HashMap<>();
            for (int number : nums) {
                this.add(number);
            }
        }

        public int showFirstUnique() {
            if (uniqList.size() == 0) {
                return -1;
            }
            return uniqList.get(0);
        }

        public void add(int value) {
            if (numbers.containsKey(value) == false) {
                uniqList.add(value);
                numbers.put(value, 1);
            } else {
                if (numbers.get(value) == 1) {
                    uniqList.remove(Integer.valueOf(value));
                }
                numbers.put(value, numbers.get(value) + 1);
            }
        }
    }

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
}
