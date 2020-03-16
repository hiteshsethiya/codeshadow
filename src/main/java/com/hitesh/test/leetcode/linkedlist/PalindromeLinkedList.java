package com.hitesh.test.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode sp = head, fp = head;
        for(; fp != null; sp = sp.next, fp = fp.next != null ? fp.next.next : null);
        for(; sp != null; sp = sp.next) stack.add(sp);
        ListNode np = head;
        while(!stack.isEmpty()) {
            if(np.val != stack.pop().val) return false;
            np = np.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(null));
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(isPalindrome(n1));
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n5;
        n5.next = n3;
        n3.next = n4;
        System.out.println(isPalindrome(n1));
        n2.val = 1;
        System.out.println(isPalindrome(n1));

    }

}
