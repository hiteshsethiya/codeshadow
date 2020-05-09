package com.hitesh.test.leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

    /*
     * Vertical Order Traversal of a Binary Tree

     * Given a binary tree, return the vertical order traversal of its nodes values.
     *
     * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
     *
     * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
     * we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
     *
     * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
     *
     * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: [3,9,20,null,null,15,7]
     * Output: [[9],[3,15],[20],[7]]
     * Explanation:
     * Without loss of generality, we can assume the root node is at position (0, 0):
     * Then, the node with value 9 occurs at position (-1, -1);
     * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
     * The node with value 20 occurs at position (1, -1);
     * The node with value 7 occurs at position (2, -2).
     * Example 2:
     *
     *
     *
     * Input: [1,2,3,4,5,6,7]
     * Output: [[4],[2],[1,5,6],[3],[7]]
     * Explanation:
     * The node with value 5 and the node with value 6 have the same position according to the given scheme.
     * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
     *
     *
     * Note:
     *
     * The tree will have between 1 and 1000 nodes.
     * Each node's value will be between 0 and 1000.
     *
     * The Below implementation can be optimised by
     */

    static public void verticalDistance(TreeMap<Integer, List<TreeNode>> verticalOrder,
                                        Map<TreeNode, Integer> levelOrder,
                                        TreeNode root, int vDistance, int hDistance) {
        if (root == null) return;
        verticalOrder.computeIfAbsent(vDistance, k -> new ArrayList<>()).add(root);
        levelOrder.put(root, hDistance);
        verticalDistance(verticalOrder, levelOrder, root.left, vDistance - 1, hDistance + 1);
        verticalDistance(verticalOrder, levelOrder, root.right, vDistance + 1, hDistance + 1);
    }

    static public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<TreeNode>> verticalOrder = new TreeMap<>();
        Map<TreeNode, Integer> levelOrder = new HashMap<>();
        verticalDistance(verticalOrder, levelOrder, root, 0, 0);
        List<List<Integer>> output = new ArrayList<>();
        verticalOrder.forEach((k, v) -> {
            v.sort((a, b) -> {
                int aL = levelOrder.get(a);
                int bL = levelOrder.get(b);
                if(aL == bL) return Integer.compare(a.val, b.val);
                return Integer.compare(aL, bL);
            });
            output.add(v.stream().map(i -> i.val).collect(Collectors.toList()));
        });
        return output;
    }

    /**
     * Sample Inputs:
     * Sample 1:
     * I/P: 0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7
     * O/P: [[9,7],[5,6],[0,2,4],[1,3],[8]]
     *
     * Sample 2:
     * I/P: 0,8,1,null,null,3,2,null,4,5,null,null,7,6
     * O/P: [[8],[0,3,6],[1,4,5],[2,7]]
     *
     * Sample 3:
     * I/P: 3,9,20,null,null,15,7
     * O/P: [[9],[3,15],[20],[7]]

     * Sample 4:
     * I/P: 0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9
     * O/P: [[4,10,11],[3,6,7],[2,5,8,9],[0],[1]]
     *
     *
     */


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            System.out.println(verticalTraversal(root));
        }
    }

}
