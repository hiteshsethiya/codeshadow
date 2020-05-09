package com.hitesh.test.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    /*
     * Given a binary tree, return the inorder traversal of its nodes' values.
     *
     * Example:
     *
     * Input: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * Output: [1,3,2]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    static public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        List<Integer> o = new ArrayList<>();
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            o.add(curr.val);
            curr = curr.right;
        }
        return o;
    }

    public static void execute(String tree, Integer[] exp) {
        TreeNode root = TreeNode.stringToTreeNode(tree);
        List<Integer> ans = inorderTraversal(root);
        System.out.println(ans);
        System.out.println(Arrays.equals(ans.toArray(), exp));
    }

    public static void main(String[] args) {
        Integer[] e = new Integer[]{3, 2, 4, 1, 6, 5, 7};
        execute("1,2,5,3,4,6,7", e);
        e = new Integer[]{1, 3, 2};
        execute("1,null,2,3", e);
    }

}
