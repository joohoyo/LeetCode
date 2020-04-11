package joohoyo.leetcode.challenge._30day;

// Diameter of Binary Tree
// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3293/
// 21:24 ~ 22:00 (36min)

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiameterOfBinaryTree {
    @Test
    public void test() {
        DiameterOfBinaryTree.Solution s = new DiameterOfBinaryTree.Solution();

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        Assertions.assertEquals(3, s.diameterOfBinaryTree(treeNode1));
        Assertions.assertEquals(0, s.diameterOfBinaryTree(treeNode5));
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            this.max = 0;
            bfs(root);
            return this.max;
        }

        private int bfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = bfs(root.left);
            int right = bfs(root.right);
            if (left + right > this.max) {
                this.max = left + right;
            }
            return Math.max(left, right) + 1;
        }
    }
}
