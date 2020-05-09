package com.hitesh.test.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    /*
     * Given a binary tree, return the postorder traversal of its nodes' values.
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
     * Output: [3,2,1]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    static public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> ll = new LinkedList<>();
        LinkedList<Integer> o = new LinkedList<>();
        ll.add(root);
        while(!ll.isEmpty()) {
            TreeNode node = ll.poll();
            o.addFirst(node.val);
            if(node.left != null) ll.push(node.left);
            if(node.right != null) ll.push(node.right);
        }
        return o;
    }

    public static void execute(String tree, Integer[] exp) {
        TreeNode root = TreeNode.stringToTreeNode(tree);
        List<Integer> ans = postorderTraversal(root);
        System.out.println(ans);
        System.out.println(Arrays.equals(ans.toArray(), exp));
    }

    public static void main(String[] args) {
        Integer[] e = new Integer[]{3,8,9,4,2,6,7,5,1};
        execute("1,2,5,3,4,6,7,null,null,8,9", e);
        e = new Integer[]{3, 2, 1};
        execute("1,null,2,3", e);
    }
}
