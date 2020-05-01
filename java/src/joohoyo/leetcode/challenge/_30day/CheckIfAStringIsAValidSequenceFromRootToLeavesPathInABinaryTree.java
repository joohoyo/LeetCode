package joohoyo.leetcode.challenge._30day;

// Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
// 20:07 ~ 20:27 (20min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {
    @Test
    public void test1() {
        CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree.Solution s = new CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree.Solution();

        TreeNode root = getTestNode();

        assertEquals(true, s.isValidSequence(root, new int[]{0, 1, 0, 1}));
        assertEquals(false, s.isValidSequence(root, new int[]{0, 0, 1}));
        assertEquals(false, s.isValidSequence(root, new int[]{0, 1, 1}));
    }

    private TreeNode getTestNode() {
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(0, new TreeNode(0), null);
        TreeNode treeNode4 = new TreeNode(0, null, new TreeNode(1));
        TreeNode treeNode5 = new TreeNode(1, new TreeNode(0), new TreeNode(0));

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        return treeNode1;
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
        public boolean isValidSequence(TreeNode root, int[] arr) {
            return search(root, arr, 0);
        }

        private boolean search(TreeNode node, int[] arr, int index) {
            if (index >= arr.length) {
                return false;
            }
            if (node.val != arr[index]) {
                return false;
            }
            if (index == arr.length - 1 && node.left == null && node.right == null) {
                return true;
            }

            boolean left = (node.left != null) ? search(node.left, arr, index + 1) : false;
            if (left) {
                return true;
            }
            return (node.right != null) ? search(node.right, arr, index + 1) : false;
        }
    }
}
