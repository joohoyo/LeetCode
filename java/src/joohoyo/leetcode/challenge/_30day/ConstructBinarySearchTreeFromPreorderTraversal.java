package joohoyo.leetcode.challenge._30day;

// Construct Binary Search Tree from Preorder Traversal
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
// 16:02 ~ 16:17 (15min)

import org.junit.jupiter.api.Test;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    @Test
    public void test() {
        ConstructBinarySearchTreeFromPreorderTraversal.Solution s = new ConstructBinarySearchTreeFromPreorderTraversal.Solution();
        TreeNode root = s.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(root);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = new TreeNode(preorder[0]);

            for (int i = 1; i < preorder.length; i++) {
                TreeNode lastNode = getLastNode(root, preorder[i]);
                if (preorder[i] < lastNode.val) {
                    lastNode.left = new TreeNode(preorder[i]);
                } else {
                    lastNode.right = new TreeNode(preorder[i]);
                }
            }
            return root;
        }

        private TreeNode getLastNode(TreeNode root, int value) {
            if (root.left == null && root.right == null) {
                return root;
            }
            if (root.left == null && value < root.val) {
                return root;
            }
            if (root.right == null && root.val < value) {
                return root;
            }
            if (value < root.val) {
                return getLastNode(root.left, value);
            }
            return getLastNode(root.right, value);
        }
    }
}
