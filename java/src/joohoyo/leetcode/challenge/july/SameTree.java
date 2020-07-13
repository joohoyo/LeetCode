package joohoyo.leetcode.challenge.july;

// Same Tree
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3389/
// 17:22 ~ 17:35  (13mins)

import joohoyo.leetcode.helper.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SameTree {
    @Test
    public void test() {
        SameTree.Solution s = new SameTree.Solution();

        TreeNode p = TreeNode.makeTreeNode("[1,2,3]");
        TreeNode q = TreeNode.makeTreeNode("[1,2,3]");
        Assertions.assertEquals(true, s.isSameTree(p, q));
    }

    @Test
    public void test2() {
        SameTree.Solution s = new SameTree.Solution();

        TreeNode p = TreeNode.makeTreeNode("[1,2]");
        TreeNode q = TreeNode.makeTreeNode("[1,null,2]");
        Assertions.assertEquals(false, s.isSameTree(p, q));
    }

    @Test
    public void test3() {
        SameTree.Solution s = new SameTree.Solution();

        TreeNode p = TreeNode.makeTreeNode("[1,2,1]");
        TreeNode q = TreeNode.makeTreeNode("[1,1,2]");
        Assertions.assertEquals(false, s.isSameTree(p, q));
    }

    @Test
    public void test4() {
        SameTree.Solution s = new SameTree.Solution();

        TreeNode p = TreeNode.makeTreeNode("[1]");
        TreeNode q = TreeNode.makeTreeNode("[1]");
        Assertions.assertEquals(true, s.isSameTree(p, q));
    }

    @Test
    public void test5() {
        SameTree.Solution s = new SameTree.Solution();

        TreeNode p = TreeNode.makeTreeNode("[1]");
        TreeNode q = TreeNode.makeTreeNode("[2]");
        Assertions.assertEquals(false, s.isSameTree(p, q));
    }

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return isSameRoot(p, q);
        }

        private boolean isSameRoot(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if ((p == null && q != null) || (p != null && q == null)) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }

            boolean leftSame = isSameRoot(p.left, q.left);
            if (leftSame == false) {
                return false;
            }

            return isSameRoot(p.right, q.right);
        }
    }
}
