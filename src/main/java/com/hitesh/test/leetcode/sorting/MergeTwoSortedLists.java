package com.hitesh.test.leetcode.sorting;

public class MergeTwoSortedLists {

    /*
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     *
     * Example:
     *
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */

    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode h, h1 = l1, h2 = l2;
        ListNode o;

        if (h1.val <= h2.val) {
            o = h1;
            h1 = h1.next;
        } else {
            o = h2;
            h2 = h2.next;
        }
        h = o;
        for (; h1 != null && h2 != null; o = o.next) {
            if (h1.val <= h2.val) {
                o.next = h1;
                h1 = h1.next;
            } else {
                o.next = h2;
                h2 = h2.next;
            }
        }
        o.next = h1 == null ? h2 : h1;
        return h;
    }

    public static void main(String[] a) {
        int[] l1 = new int[]{1, 2, 4};
        int[] l2 = new int[]{1, 3, 4, 5};
        ListNode ll1 = ListNode.create(l1);
        ListNode ll2 = ListNode.create(l2);
        ListNode o = mergeTwoLists(ll1, ll2);
        o.print();
    }

}
