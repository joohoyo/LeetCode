package joohoyo.leetcode.challenge._30day;

// Binary Tree Maximum Path Sum
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3314/
// 18:00 ~ 18:38 (38min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeMaximumPathSum {
    @Test
    public void test() {
        BinaryTreeMaximumPathSum.Solution s = new BinaryTreeMaximumPathSum.Solution();

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        assertEquals(6, s.maxPathSum(treeNode1));
    }

    @Test
    public void test2() {
        BinaryTreeMaximumPathSum.Solution s = new BinaryTreeMaximumPathSum.Solution();

        TreeNode treeNode1 = new TreeNode(-10);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        assertEquals(42, s.maxPathSum(treeNode1));
    }

    @Test
    public void test3() {
        BinaryTreeMaximumPathSum.Solution s = new BinaryTreeMaximumPathSum.Solution();

        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(-1);
        TreeNode treeNode3 = new TreeNode(-2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        assertEquals(10, s.maxPathSum(treeNode1));
    }

    @Test
    public void test4() {
        BinaryTreeMaximumPathSum.Solution s = new BinaryTreeMaximumPathSum.Solution();

        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        assertEquals(54, s.maxPathSum(treeNode1));
    }

    @Test
    public void test5() {
        BinaryTreeMaximumPathSum.Solution s = new BinaryTreeMaximumPathSum.Solution();

        TreeNode treeNode1 = new TreeNode(1);

        assertEquals(1, s.maxPathSum(treeNode1));
    }

    @Test
    public void test6() {
        BinaryTreeMaximumPathSum.Solution s = new BinaryTreeMaximumPathSum.Solution();

        TreeNode treeNode1 = new TreeNode(-6, new TreeNode(-6), null);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, new TreeNode(-6));
        TreeNode treeNode3 = new TreeNode(2, treeNode2, null);
        TreeNode treeNode4 = new TreeNode(-3, new TreeNode(-6), treeNode3);
        TreeNode root = new TreeNode(9, new TreeNode(6), treeNode4);

        assertEquals(16, s.maxPathSum(root));
    }

    @Test
    public void test7() {
        BinaryTreeMaximumPathSum.Solution s = new BinaryTreeMaximumPathSum.Solution();

        TreeNode root = new TreeNode(-2, new TreeNode(1), null);

        assertEquals(1, s.maxPathSum(root));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int max = 0;

        public int maxPathSum(TreeNode root) {
            max = root.val;
            search(root);
            return max;
        }

        private int search(TreeNode node) {
            if (node.left == null && node.right == null) {
                max = Math.max(max, node.val);
                return node.val;
            }

            int left = node.left != null ? search(node.left) : 0;
            int right = node.right != null ? search(node.right) : 0;

            int leftSum = left + node.val;
            int rightSum = right + node.val;
            int allSum = left + node.val + right;

            int childMax = Math.max(leftSum, rightSum);
            int allMax = Math.max(childMax, allSum);

            max = Math.max(max, allMax);

            return Math.max(childMax, node.val);
        }
    }
}
