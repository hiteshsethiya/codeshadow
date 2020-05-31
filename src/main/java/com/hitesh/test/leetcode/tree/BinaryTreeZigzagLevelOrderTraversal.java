package com.hitesh.test.leetcode.tree;

import com.hitesh.test.leetcode.matrix.MatrixUtil;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    /*
     * Given a binary tree, return the zigzag level order traversal of its nodes' values.
     * (ie, from left to right, then right to left for the next level and alternate between).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its zigzag level order traversal as:
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     */

    static public void bfs(TreeNode node, int level, List<List<Integer>> output) {
        if(node == null) return;
        if(level >= output.size()) {
            output.add(level, new ArrayList<>());
        }
        if(level % 2 == 0) {
            output.get(level).add(node.val);
        } else {
            output.get(level).add(0, node.val);
        }
        if(node.left != null) bfs(node.left, level + 1, output);
        if(node.right != null) bfs(node.right, level + 1, output);
    }

    static public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        bfs(root, 0, output);
        return output;
    }

    public static void execute(String tree) {
        TreeNode root = TreeNode.stringToTreeNode(tree);
        List<List<Integer>> ans = zigzagLevelOrder(root);
        MatrixUtil.soutMatrix(ans);
        System.out.println();
    }

    public static void main(String[] args) {
        execute("3,9,20,null,null,15,7");
        execute("1,2,5,3,4,6,7,null,null,8,9");
    }

}
