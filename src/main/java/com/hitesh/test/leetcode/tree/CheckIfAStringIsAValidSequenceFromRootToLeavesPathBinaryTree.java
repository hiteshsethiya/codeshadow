package com.hitesh.test.leetcode.tree;

public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathBinaryTree {

    /*
     * Given a binary tree where each path going from the root to any leaf form a valid sequence,
     * check if a given string is a valid sequence in such binary tree.
     *
     * We get the given string from the concatenation of an array of integers arr and
     * the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
     *
     * Example 1:
     *
     *
     * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
     * Output: true
     * Explanation:
     * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
     * Other valid sequences are:
     * 0 -> 1 -> 1 -> 0
     * 0 -> 0 -> 0
     *
     * Example 2:
     *
     * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
     * Output: false
     * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
     *
     * Example 3:
     *
     * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
     * Output: false
     * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
     *
     * Constraints:
     *
     * 1 <= arr.length <= 5000
     * 0 <= arr[i] <= 9
     * Each node's value is between [0 - 9].
     */
    static public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequenceUtil(root, arr, 0);
    }

    static public boolean isValidSequenceUtil(TreeNode root, int[] arr, int n) {
        if(root == null) return false;
        if(n >= arr.length) return false;
        if(root.val != arr[n]) {
            return false;
        }
        if(n == arr.length - 1 && root.left == null && root.right == null) return true;
        return isValidSequenceUtil(root.left, arr, n + 1)
                || isValidSequenceUtil(root.right, arr, n + 1);
    }

    public static void execute(String tree, int[] arr, boolean exp) {
        TreeNode root = TreeNode.stringToTreeNode(tree);
        boolean ans = isValidSequence(root, arr);
        System.out.println("Ans : " +  ans);
        System.out.println(exp == ans);
    }

    public static void main(String[] args) {
        execute("0,1,0,0,1,0,null,null,1,0,0", new int[]{0,1,0,1}, true);
        execute("0,1,0,0,1,0,null,null,1,0,0", new int[]{0,0,1}, false);
        execute("0,1,0,0,1,0,null,null,1,0,0", new int[]{0,1,1}, false);
    }
}
