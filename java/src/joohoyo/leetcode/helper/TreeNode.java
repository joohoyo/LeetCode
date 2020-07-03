package joohoyo.leetcode.helper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode makeTreeNode(String s) {
//        [3,9,20,null,null,15,7]
        s = s.replaceAll("[\\[\\]]", "");
        if (s.isEmpty()) {
            return null;
        }

        List<Integer> treeNode = Arrays.stream(s.split(","))
                .map(e -> "null".equals(e) ? null : Integer.valueOf(e))
                .collect(Collectors.toList());

        TreeNode[] nodes = new TreeNode[treeNode.size()];
        nodes[0] = new TreeNode(treeNode.get(0));
        for (int i = 1; i < treeNode.size(); i++) {
            if (treeNode.get(i) == null) {
                continue;
            }

            nodes[i] = new TreeNode(treeNode.get(i));
            int parent = (i - 1) / 2;
            if (i % 2 == 0) {
                nodes[parent].right = nodes[i];
            } else {
                nodes[parent].left = nodes[i];
            }
        }
        return nodes[0];
    }

}
