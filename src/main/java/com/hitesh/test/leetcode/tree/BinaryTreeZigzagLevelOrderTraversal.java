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

    public static boolean isEmpty(TreeNode node) {
        return node.left == node;
    }

    static public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        boolean leftToRight = false;
        TreeNode empty = new TreeNode(Integer.MIN_VALUE);
        empty.left = empty;
        empty.right = empty;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(empty);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> iOutput = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            if(isEmpty(pop)) {
                if(queue.isEmpty()) break;
                queue.add(empty);
                leftToRight = !leftToRight;
                output.add(iOutput);
                iOutput = new ArrayList<>();
            } else {
                iOutput.add(pop.val);
                if(leftToRight) {
                    if(pop.left != null) queue.add(pop.left);
                    if(pop.right != null) queue.add(pop.right);
                } else {
                    if(pop.right != null) queue.add(pop.right);
                    if(pop.left != null) queue.add(pop.left);
                }
            }
        }
        output.add(iOutput);
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
