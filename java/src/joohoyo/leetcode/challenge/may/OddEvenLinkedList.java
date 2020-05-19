package joohoyo.leetcode.challenge.may;

// Odd Even Linked List
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/
// 11:48 ~  (min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {
    private void assertListNodeEquals(int[] expected, ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        ListNode x = listNode;

        while (x != null) {
            list.add(x.val);
            x = x.next;
        }

        Assertions.assertEquals(expected.length, list.size());
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], (int) list.get(i));
        }
    }

    @Test
    public void test() {
        OddEvenLinkedList.Solution s = new OddEvenLinkedList.Solution();

        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(2);
        ListNode e3 = new ListNode(3);
        ListNode e4 = new ListNode(4);
        ListNode e5 = new ListNode(5);
        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;

        assertListNodeEquals(new int[]{1, 3, 5, 2, 4}, s.oddEvenList(e1));

        ListNode o1 = new ListNode(1);
        ListNode o2 = new ListNode(2);
        ListNode o3 = new ListNode(3);
        ListNode o4 = new ListNode(4);
        ListNode o5 = new ListNode(5);
        ListNode o6 = new ListNode(6);
        ListNode o7 = new ListNode(7);
        o2.next = o1;
        o1.next = o3;
        o3.next = o5;
        o5.next = o6;
        o6.next = o4;
        o4.next = o7;

        assertListNodeEquals(new int[]{2, 3, 6, 7, 1, 5, 4}, s.oddEvenList(o2));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
}
