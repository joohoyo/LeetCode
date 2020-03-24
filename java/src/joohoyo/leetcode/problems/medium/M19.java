package joohoyo.leetcode.problems.medium;

// 19. Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// 15:28 ~ 16:00 (32min)

public class M19 {
    public static void main(String[] args) {
        new M19().test();
    }

    public void test() {
        M19.Solution s = new M19.Solution();

//        int n = 1;
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        ListNode result = s.removeNthFromEnd(l1, n);

        int n = 1;
        ListNode l1 = new ListNode(1);
        ListNode result = s.removeNthFromEnd(l1, n);

        while (result != null) {
            System.out.println(result.val + " -> ");
            result = result.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode answer = head;

            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }

            int start = 0;
            if (count == n) {
                answer = answer.next;
                start = 1;
            }

            head = answer;
            ListNode skip = null;
            for (int i = start; i < count; i++) {
                if (i == count - n - 1) {
                    skip = head;
                } else if (i == count - n) {
                    skip.next = head.next;
                }
                head = head.next;
            }

            return answer;
        }
    }

}
