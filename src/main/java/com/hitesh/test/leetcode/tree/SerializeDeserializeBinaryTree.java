package com.hitesh.test.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    /*
     * Serialization is the process of converting a data structure or object into a sequence of bits so that
     * it can be stored in a file or memory buffer, or transmitted across a network connection link to be
     * reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree.
     * There is no restriction on how your serialization/deserialization algorithm should work.
     * You just need to ensure that a binary tree can be serialized to a string and this string can be
     * deserialized to the original tree structure.
     *
     * Example:
     *
     * You may serialize the following tree:
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * as "[1,2,3,null,null,4,5]"
     * Clarification: The above format is the same as how LeetCode serializes a binary tree.
     * You do not necessarily need to follow this format, so please be creative and come up with
     * different approaches yourself.
     *
     * Note: Do not use class member/global/static variables to store states.
     * Your serialize and deserialize algorithms should be stateless.
     */

    public class Codec {

        private static final String SPLITTER = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            if (root == null) return "null";
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append("null");
                } else {
                    sb.append(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
                sb.append(SPLITTER);
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(isEmpty(data)) return null;
            String[] elements = data.split(SPLITTER);
            TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            for(int i = 1; i < elements.length && !q.isEmpty(); ++i) {
                TreeNode parent = q.poll();
                if(!isEmpty(elements[i])) {
                    parent.left = new TreeNode(Integer.parseInt(elements[i]));
                    q.add(parent.left);
                }
                ++i;
                if(!isEmpty(elements[i])) {
                    parent.right = new TreeNode(Integer.parseInt(elements[i]));
                    q.add(parent.right);
                }
            }

            return root;
        }

        private boolean isEmpty(String value) {
            return value == null || value.trim().isEmpty() || value.equalsIgnoreCase("null");
        }
    }
}
