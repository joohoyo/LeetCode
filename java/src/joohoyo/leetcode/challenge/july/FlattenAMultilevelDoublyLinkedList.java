package joohoyo.leetcode.challenge.july;

// Flatten a Multilevel Doubly Linked List
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3386/
// 21:24 ~ 22:05 (41mins)

import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        new FlattenAMultilevelDoublyLinkedList().test();
        new FlattenAMultilevelDoublyLinkedList().test2();
        new FlattenAMultilevelDoublyLinkedList().test3();
    }

    public void test() {
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);

        head1.next = head2;
        head2.prev = head1;

        head1.child = head3;

        Solution s = new Solution();
        printNode(s.flatten(head1));
    }

    public void test2() {
        Node head1 = new Node(1);

        Solution s = new Solution();
        printNode(s.flatten(head1));
    }

    public void test3() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        node1.child = node2;

        Solution s = new Solution();
        printNode(s.flatten(node1));
    }

    private void printNode(Node head) {
        while (head != null) {
            System.out.print(head.val + " - ");
            head = head.next;
        }
        System.out.println();
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    class Solution {
        public Node flatten(Node head) {
            if (head == null) {
                return null;
            }

            Node result = new Node(-1);
            result.next = head;

            Node node = head;
            Stack<Node> stack = new Stack<>();
            while (node != null && (stack.size() > 0 || node.next != null || node.child != null)) {
                if (node.child == null && node.next != null) {
                    ;
                } else if (node.child != null) {
                    stack.add(node.next);
                    node.child.prev = node;
                    node.next = node.child;
                    node.child = null;
                } else if (node.next == null && stack.size() > 0) {
                    node.next = stack.pop();
                    if (node.next != null) {
                        node.next.prev = node;
                    }
                }
                node = node.next;
            }
            return result.next;
        }
    }
}
