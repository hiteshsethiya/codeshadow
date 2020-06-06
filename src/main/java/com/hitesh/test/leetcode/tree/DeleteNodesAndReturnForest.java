package com.hitesh.test.leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {

    /**
     * Given the root of a binary tree, each node in the tree has a distinct value.
     * <p>
     * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
     * <p>
     * Return the roots of the trees in the remaining forest.  You may return the result in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * https://assets.leetcode.com/uploads/2019/07/01/screen-shot-2019-07-01-at-53836-pm.png
     * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
     * Output: [[1,2,null,4],[6],[7]]
     * <p>
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the given tree is at most 1000.
     * Each node has a distinct value between 1 and 1000.
     * to_delete.length <= 1000
     * to_delete contains distinct values between 1 and 1000.
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void dfsUtil(TreeNode node, TreeNode parent, Set<Integer> delete, List<TreeNode> output) {
        if(node == null) return;
        dfsUtil(node.left, node, delete, output);
        dfsUtil(node.right, node, delete, output);
        if(delete.contains(node.val)) {
            delete.remove(node.val);
            if(parent != null) {
                if(parent.left != null && parent.left.val == node.val) parent.left = null;
                if(parent.right != null && parent.right.val == node.val) parent.right = null;
            }
            if(node.left != null) output.add(node.left);
            if(node.right != null) output.add(node.right);
        } else if(parent == null) {
            output.add(node);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) return null;
        if(to_delete == null || to_delete.length == 0) return Collections.singletonList(root);
        Set<Integer> delete = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> output = new ArrayList<>();
        dfsUtil(root, null, delete, output);
        return output;
    }

}
