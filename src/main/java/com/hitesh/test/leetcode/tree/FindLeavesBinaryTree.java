package com.hitesh.test.leetcode.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class FindLeavesBinaryTree {

    /**
     * Given a binary tree, collect a tree's nodes as if you were doing this:
     * Collect and remove all leaves, repeat until the tree is empty.
     *
     *
     *
     * Example:
     *
     * Input: [1,2,3,4,5]
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     *
     * Output: [[4,5,3],[2],[1]]
     *
     *
     *
     * Explanation:
     *
     * 1. Removing the leaves [4,5,3] would result in this tree:
     *
     *           1
     *          /
     *         2
     *
     *
     *
     * 2. Now removing the leaf [2] would result in this tree:
     *
     *           1
     *
     *
     *
     * 3. Now removing the leaf [1] would result in the empty tree:
     *
     *           []
     *
     * [[3,5,4],[2],[1]], [[3,4,5],[2],[1]], etc, are also consider correct
     * answers since per each level it doesn't matter the order on which elements are returned.
     */

    boolean isLeaf(TreeNode node) {
        return node == null || (node.left == null && node.right == null);
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> o = new ArrayList<>();
        if(root == null) return o;
        int i = 0;
        while(!isLeaf(root)) {
            o.add(new ArrayList<>());
            findLeavesUtil(root, o.get(i++));
        }
        o.add(new ArrayList<>());
        o.get(o.size() - 1).add(root.val);
        root = null;
        return o;
    }





    public void findLeavesUtil(TreeNode root, List<Integer> leaves) {
        if(root == null) return;
        if(root.left != null && isLeaf(root.left)) {
            leaves.add(root.left.val);
            root.left = null;
        } else {
            findLeavesUtil(root.left, leaves);
        }

        TreeMap<Integer, String> a = new TreeMap<>(
                (a1, b) -> a1.equals(b) ? -1 : Integer.compare(a1, b)
        );
        a.lowerEntry(1);
        if(root.right != null && isLeaf(root.right)) {
            leaves.add(root.right.val);
            root.right = null;
        } else {
            findLeavesUtil(root.right, leaves);
        }
    }
}







