package joohoyo.leetcode.challenge._30day;

// Middle of the Linked List
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3290/
// 10:16 ~ 10:29 (13min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MiddleOfTheLinkedList {
    @Test
    public void test() {
        MiddleOfTheLinkedList.Solution s = new MiddleOfTheLinkedList.Solution();

        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(2);
        ListNode e3 = new ListNode(3);
        ListNode e4 = new ListNode(4);
        ListNode e5 = new ListNode(5);
        ListNode e6 = new ListNode(6);
        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;
        e5.next = e6;

        ListNode listNode = s.middleNode(e1);
        Assertions.assertEquals(4, listNode.val);
        Assertions.assertEquals(5, listNode.next.val);
        Assertions.assertEquals(6, listNode.next.next.val);
        Assertions.assertEquals(null, listNode.next.next.next);

        ListNode o1 = new ListNode(1);
        ListNode o2 = new ListNode(2);
        ListNode o3 = new ListNode(3);
        ListNode o4 = new ListNode(4);
        ListNode o5 = new ListNode(5);
        o1.next = o2;
        o2.next = o3;
        o3.next = o4;
        o4.next = o5;

        listNode = s.middleNode(o1);
        Assertions.assertEquals(3, listNode.val);
        Assertions.assertEquals(4, listNode.next.val);
        Assertions.assertEquals(5, listNode.next.next.val);
        Assertions.assertEquals(null, listNode.next.next.next);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode answer = new ListNode(0);
            answer.next = head;

            int count = 0;
            while (true) {
                count++;
                head = head.next;
                if (head == null) {
                    break;
                }
            }
            for (int i = 0; i <= count / 2; i++) {
                answer = answer.next;
            }
            return answer;
        }
    }
}
