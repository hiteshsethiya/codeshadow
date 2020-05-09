package com.hitesh.test.leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeMaximumPathSum {

    /*
     * Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from some starting
     * node to any node in the tree along the parent-child connections.
     * The path must contain at least one node and does not need to go through the root.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * Output: 6
     *
     * Example 2:
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * Output: 42
     */

    static public int maxPathSumUtil(TreeNode root, AtomicInteger maxAt) {
        if(root == null) return Integer.MIN_VALUE;
        if(root.left == null && root.right == null) {
            maxAt.set(max(maxAt.get(), root.val));
            return root.val;
        }
        long res = root.val, ls = Integer.MIN_VALUE, rs = Integer.MIN_VALUE;
        if(root.left != null) {
            ls = maxPathSumUtil(root.left, maxAt);
            res += ls;
        }
        if(root.right != null) {
            rs = maxPathSumUtil(root.right, maxAt);
            res += rs;
        }
        maxAt.set(max(maxAt.get(), root.val, ls, rs, res, root.val + rs, root.val + ls));
        return max(root.val, ls + root.val, rs + root.val);
    }

    static int max(long... values) {
        if(values == null) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(long i : values) {
            if(i <= Integer.MIN_VALUE) continue;
            max = (int) Math.max(i, max);
        }
        return max;
    }

    static public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        maxPathSumUtil(root, max);
        return max.get();
    }


    /**
     * TEST INPUTS:
     * [-10,9,20,null,null,15,7] = 42
     * [-2,-1] = -1
     * [1,-2,3] = 4
     * [1,-2,-3,1,3,-2,null,-1] = 3
     */

    public static void execute(String tree, int exp) {
        TreeNode root = TreeNode.stringToTreeNode(tree);
        int ans = maxPathSum(root);
        System.out.println(ans);
        System.out.println(exp == ans);
    }

    public static void main(String[] args) throws IOException {

        execute("-1,5,null,4,null,null,2,-4", 11);
        execute("1,-2,-3,1,3,-2,null,-1", 3);
        execute("1,-2,3", 4);
        execute("-2,-1", -1);
        execute("-10,9,20,null,null,15,7", 42);

        /*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            System.out.println(maxPathSum(root));
        }*/
    }

}
