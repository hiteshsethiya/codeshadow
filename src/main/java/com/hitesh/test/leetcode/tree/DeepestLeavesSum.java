package com.hitesh.test.leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import static com.hitesh.test.leetcode.tree.TreeNode.stringToTreeNode;

public class DeepestLeavesSum {

    /*
     * Given a binary tree, return the sum of values of its deepest leaves.
     *
     * Img: https://assets.leetcode.com/uploads/2019/07/31/1483_ex1.png
     *
     * Example 1:
     * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * Output: 15
     *
     * Constraints:
     *
     * The number of nodes in the tree is between 1 and 10^4.
     * The value of nodes is between 1 and 100.
     */

    static public int getMaxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    static public int getSum(TreeNode root, int currentDepth, int maxDepth) {
        if(root == null || maxDepth == 0) return 0;
        if(currentDepth == maxDepth - 1) {
            return root.val;
        }
        int sum = 0;
        sum += getSum(root.left, currentDepth + 1, maxDepth);
        sum += getSum(root.right, currentDepth + 1, maxDepth);
        return sum;
    }

    static public int deepestLeavesSum(TreeNode root) {
        return getSum(root, 0, getMaxDepth(root));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);

            int ret = deepestLeavesSum(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}
