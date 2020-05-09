package com.hitesh.test.leetcode.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /*
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode h : lists) {
            if (h != null) heap.offer(h);
        }
        if (heap.isEmpty()) return null;
        ListNode head = new ListNode(heap.peek().val, heap.poll().next), curr = head;
        if(head.next != null) heap.offer(head.next);
        while (!heap.isEmpty()) {
            ListNode iValue = heap.poll();
            curr.next = new ListNode(iValue.val);
            curr = curr.next;
            if (iValue.next != null) {
                heap.offer(iValue.next);
            }
        }
        return head;
    }

    public static void main(String[] a) {
        int[] l1 = new int[]{1, 2, 4};
        int[] l2 = new int[]{1, 3, 4, 5};
        int[] l3 = new int[]{7, 8, 9, 10};
        ListNode ll1 = ListNode.create(l1);
        ListNode ll2 = ListNode.create(l2);
        ListNode ll3 = ListNode.create(l3);
        ListNode o = mergeKLists(new ListNode[]{ll1, ll2, ll3});
        assert o != null;
        o.print();
    }

}
