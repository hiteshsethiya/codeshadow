package com.hitesh.test.leetcode.tree;

import java.util.LinkedList;

public class KthSmallestElementBST {

    /*
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     *
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
     *
     * Example 1:
     *
     * Input: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * Output: 1
     *
     * Example 2:
     *
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * Output: 3
     *
     * Follow up:
     *
     * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
     * How would you optimize the kthSmallest routine?
     *
     * - In this case, use a Doubly linked list with references to the nodes in the BST.
     * Then searching Kth element is O(K)
     * Insert: O(H + LogN)
     * Search: O(H)
     */

    static public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(--k == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }

    public static void execute(String tree, int k, int exp) {
        TreeNode root = TreeNode.stringToTreeNode(tree);
        int ans = kthSmallest(root, k);
        System.out.println(ans);
        System.out.println(exp == ans);
    }

    public static void main(String[] args) {
        execute("3,1,4,null,2", 1, 1);
        execute("3,1,4,null,2", 2, 2);
        execute("3,1,4,null,2", 3, 3);
        execute("3,1,4,null,2", 4, 4);
        execute("5,3,6,2,4,null,null,1", 3, 3);
    }

}
