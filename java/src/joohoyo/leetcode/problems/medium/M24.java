package joohoyo.leetcode.problems.medium;

// 24. Swap Nodes in Pairs
// https://leetcode.com/problems/swap-nodes-in-pairs/
// 15:13 ~ gg (min)

public class M24 {
    public static void main(String[] args) {
        new M24().test();
    }

    public void test() {
        M24.Solution s = new M24.Solution();
        int n = 1;
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = s.swapPairs(l1);

//        int n = 1;
//        SwapNodesInPairs.ListNode l1 = new SwapNodesInPairs.ListNode(1);
//        SwapNodesInPairs.ListNode result = s.swapPairs(l1);

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
        public ListNode swapPairs(ListNode head) {
            ListNode answer = new ListNode(0);
            answer.next = head;

            ListNode current = answer;
            while (current.next != null && current.next.next != null) {
                ListNode first = current.next;
                ListNode second = current.next.next;
                first.next = second.next;
                current.next = second;
                current.next.next = first;
                current = current.next.next;
            }
            return answer.next;
        }
    }

}
