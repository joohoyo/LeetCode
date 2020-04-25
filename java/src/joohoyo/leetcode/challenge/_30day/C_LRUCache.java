package joohoyo.leetcode.challenge._30day;

// LRU Cache
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3309/
// 16:43 ~ 17:03 (20min)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C_LRUCache {
    public static void main(String[] args) {
        new C_LRUCache().test();
        System.out.println();
        new C_LRUCache().test1();
        System.out.println();
    }

    public void test() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    public void test1() {
        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(2)); // 3
    }

    class LRUCache {
        int capacity;
        Map<Integer, Integer> map;
        List<Integer> stack;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.stack = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key) == false) {
                return -1;
            }
            reOrderStack(key);
            return map.get(key);
        }

        private void reOrderStack(int key) {
            Integer k = key;
            stack.remove(k);
            stack.add(k);
        }

        public void put(int key, int value) {
            if (map.containsKey(key) == false) {
                if (stack.size() == capacity) {
                    map.remove(stack.remove(0));
                }
                stack.add(key);
            } else {
                reOrderStack(key);
            }
            map.put(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
