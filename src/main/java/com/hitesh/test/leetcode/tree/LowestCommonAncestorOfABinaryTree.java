package com.hitesh.test.leetcode.tree;

public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);
        if(leftLca != null && rightLca != null) return root;
        return leftLca == null ? rightLca : leftLca;
    }


}
