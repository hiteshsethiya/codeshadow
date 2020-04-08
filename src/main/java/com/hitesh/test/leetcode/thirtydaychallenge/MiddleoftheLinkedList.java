package com.hitesh.test.leetcode.thirtydaychallenge;

import com.hitesh.test.leetcode.linkedlist.ListNode;

public class MiddleoftheLinkedList {

    /**
     * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
     *
     * If there are two middle nodes, return the second middle node.
     *
     *
     *
     * Example 1:
     *
     * Input: [1,2,3,4,5]
     * Output: Node 3 from this list (Serialization: [3,4,5])
     * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
     * Note that we returned a ListNode object ans, such that:
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
     * Example 2:
     *
     * Input: [1,2,3,4,5,6]
     * Output: Node 4 from this list (Serialization: [4,5,6])
     * Since the list has two middle nodes with values 3 and 4, we return the second one.
     *
     *
     * Note:
     *
     * The number of nodes in the given list will be between 1 and 100.
     */

    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        int len = 1;
        ListNode s = head;
        for(ListNode f = head; f.next != null && f.next.next != null; s = s.next, f = f.next.next, len++);
        if(len % 2 == 0) return s.next;
        return s;
    }

    public static void main(String[] args) {

    }
}
