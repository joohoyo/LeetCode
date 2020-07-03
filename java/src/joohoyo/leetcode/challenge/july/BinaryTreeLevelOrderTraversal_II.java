package joohoyo.leetcode.challenge.july;

// Binary Tree Level Order Traversal II
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3378/
// 18:33 ~ 19:00 (27mins)

import joohoyo.leetcode.helper.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_II {
    @Test
    public void test() {
        BinaryTreeLevelOrderTraversal_II.Solution s = new BinaryTreeLevelOrderTraversal_II.Solution();

        System.out.println(s.levelOrderBottom(TreeNode.makeTreeNode("[]")));

        System.out.println(s.levelOrderBottom(TreeNode.makeTreeNode("[3,9,20,null,null,15,7]")));
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root != null) {
                search(result, root, 0);
            }

            Collections.reverse(result);
            return result;
        }

        private void search(List<List<Integer>> result, TreeNode root, int depth) {
            if (result.size() <= depth) {
                result.add(new ArrayList<>());
            }
            result.get(depth).add(root.val);

            if (root.left != null) {
                search(result, root.left, depth + 1);
            }
            if (root.right != null) {
                search(result, root.right, depth + 1);
            }
        }
    }
}
