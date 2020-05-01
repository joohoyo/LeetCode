package joohoyo.leetcode.challenge._30day;

// Binary Tree Maximum Path Sum
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3314/
// 18:00 ~ 18:38 (38min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeMaximumPathSum2 {
    @Test
    public void test() {
        BinaryTreeMaximumPathSum2.Solution s = new BinaryTreeMaximumPathSum2.Solution();

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        assertEquals(6, s.maxPathSum(treeNode1));
    }

    @Test
    public void test2() {
        BinaryTreeMaximumPathSum2.Solution s = new BinaryTreeMaximumPathSum2.Solution();

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
        BinaryTreeMaximumPathSum2.Solution s = new BinaryTreeMaximumPathSum2.Solution();

        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(-1);
        TreeNode treeNode3 = new TreeNode(-2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        assertEquals(10, s.maxPathSum(treeNode1));
    }

    @Test
    public void test4() {
        BinaryTreeMaximumPathSum2.Solution s = new BinaryTreeMaximumPathSum2.Solution();

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
        BinaryTreeMaximumPathSum2.Solution s = new BinaryTreeMaximumPathSum2.Solution();

        TreeNode treeNode1 = new TreeNode(1);

        assertEquals(1, s.maxPathSum(treeNode1));
    }

    @Test
    public void test6() {
        BinaryTreeMaximumPathSum2.Solution s = new BinaryTreeMaximumPathSum2.Solution();

        TreeNode treeNode1 = new TreeNode(-6, new TreeNode(-6), null);
        TreeNode treeNode2 = new TreeNode(2, treeNode1, new TreeNode(-6));
        TreeNode treeNode3 = new TreeNode(2, treeNode2, null);
        TreeNode treeNode4 = new TreeNode(-3, new TreeNode(-6), treeNode3);
        TreeNode root = new TreeNode(9, new TreeNode(6), treeNode4);

        assertEquals(16, s.maxPathSum(root));
    }

    @Test
    public void test7() {
        BinaryTreeMaximumPathSum2.Solution s = new BinaryTreeMaximumPathSum2.Solution();

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
            if (node == null) {
                return 0;
            }

            int left = Math.max(search(node.left), 0);
            int right = Math.max(search(node.right), 0);
            int all = left + right + node.val;

            max = Math.max(max, all);

            return node.val + Math.max(left, right);
        }
    }
}
