package com.hitesh.test.leetcode.sorting;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode create(int[] a) {
        ListNode h = new ListNode(a[0]);
        ListNode i = h;
        for (int k = 1; k < a.length; k++) {
            i.next = new ListNode(a[k]);
            i = i.next;
        }
        return h;
    }

    public void print() {
        for (ListNode i = this; i != null; i = i.next) System.out.print(i.val + " -> ");
        System.out.println();
    }
}
