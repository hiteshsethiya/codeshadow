package com.hitesh.test.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidateBinarySearchTree {

    /*
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     *
     * Example 1:
     *
     *     2
     *    / \
     *   1   3
     *
     * Input: [2,1,3]
     * Output: true
     * Example 2:
     *
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     *
     * Input: [5,1,4,null,null,3,6]
     * Output: false
     * Explanation: The root node's value is 5 but its right child's value is 4.
     */

    // Doesn't handle duplicates well.
    static public boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        if(root.val < min || root.val > max) return false;
        return isValidBST(root.left, min, root.val-1)
                && isValidBST(root.right, root.val+1, max);
    }

    // Runtime: 0 ms, faster than 100.00%,  39.4 MB, less than 80.47%
    static public boolean isValidBST(TreeNode root, TreeNode left, TreeNode right) {
        if(root == null) return true;
        if(left != null && left.val >= root.val) return false;
        if(right != null && right.val <= root.val) return false;
        return isValidBST(root.left, left, root)
                && isValidBST(root.right, root, right);
    }

    static public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(root, null, null);
    }

    /*
     * Sample Inputs:
     * -2147483648,-2147483648 -> FALSE
     * 5,1,4,null,null,3,6 -> FALSE
     * 2,1,3 -> TRUE
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            System.out.println(isValidBST(root));
        }
    }

}
