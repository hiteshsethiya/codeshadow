package com.hitesh.test.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBinarySearchTreefromPreorderTraversal {

    /*
     * Return the root node of a binary search tree that matches the given preorder traversal.
     *
     * (Recall that a binary search tree is a binary tree where for every node,
     * any descendant of node.left has a value < node.val, and any descendant of
     * node.right has a value > node.val.
     * Also recall that a preorder traversal displays the value of the node first,
     * then traverses node.left, then traverses node.right.)
     *
     *
     *
     * Example 1:
     *
     * Input: [8,5,1,7,10,12]
     * Output: [8,5,10,1,7,null,12]
     *
     *              8
     *            /   \
     *           5     10
     *          / \      \
     *         1   7      12
     *
     * Note:
     *
     * 1 <= preorder.length <= 100
     * The values of preorder are distinct.
     *
     */

    static public TreeNode insert(TreeNode root, int data) {
        if(root == null) return new TreeNode(data);
        if(data <= root.val) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; ++i) {
            insert(root, preorder[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{8,5,1,7,10,12};
        System.out.println(bstFromPreorder(a));
    }

}
