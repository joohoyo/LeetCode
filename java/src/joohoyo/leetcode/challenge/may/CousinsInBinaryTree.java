package joohoyo.leetcode.challenge.may;

// Cousins in Binary Tree
// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
// 10:44 ~ 11:19 (35min)

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CousinsInBinaryTree {
    @Test
    public void test() {
        CousinsInBinaryTree.Solution s = new CousinsInBinaryTree.Solution();

        TreeNode root1 = makeTreeNode(new Integer[]{1, 2, 3, 4});
        assertEquals(false, s.isCousins(root1, 4, 3));

        TreeNode root2 = makeTreeNode(new Integer[]{1, 2, 3, null, 4, null, 5});
        assertEquals(true, s.isCousins(root2, 5, 4));

        TreeNode root3 = makeTreeNode(new Integer[]{1, 2, 3, null, 4});
        assertEquals(false, s.isCousins(root3, 2, 3));

        TreeNode root4 = makeTreeNode(new Integer[]{1, 2, 3, null, 4});
        assertEquals(false, s.isCousins(root4, 1, 3));
    }

    private TreeNode makeTreeNode(Integer[] treeNode) {
        TreeNode[] nodes = new TreeNode[treeNode.length];
        nodes[0] = new TreeNode(treeNode[0]);
        for (int i = 1; i < treeNode.length; i++) {
            if (treeNode[i] == null) {
                continue;
            }

            nodes[i] = new TreeNode(treeNode[i]);
            int parent = (i - 1) / 2;
            if (i % 2 == 0) {
                nodes[parent].right = nodes[i];
            } else {
                nodes[parent].left = nodes[i];
            }
        }
        return nodes[0];
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
        int[] depths = new int[]{0, 0};
        int[] parents = new int[]{0, 0};

        public boolean isCousins(TreeNode root, int x, int y) {
            depths = new int[]{0, 0};
            parents = new int[]{0, 0};

            getDepth(new TreeNode(-1), root, x, y, 0);

            return parents[0] != parents[1] && depths[0] == depths[1];
        }

        private void getDepth(TreeNode parent, TreeNode root, int x, int y, int depth) {
            if (root == null) {
                return;
            }

            if (root.val == x) {
                depths[0] = depth;
                parents[0] = parent.val;
            }
            if (root.val == y) {
                depths[1] = depth;
                parents[1] = parent.val;
            }

            getDepth(root, root.left, x, y, depth + 1);
            getDepth(root, root.right, x, y, depth + 1);
        }
    }
}
