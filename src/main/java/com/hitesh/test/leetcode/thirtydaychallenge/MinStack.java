package com.hitesh.test.leetcode.thirtydaychallenge;

import java.util.Stack;

public class MinStack {

    /*
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *
     *
     * Example:
     *
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> Returns -3.
     * minStack.pop();
     * minStack.top();      --> Returns 0.
     * minStack.getMin();   --> Returns -2.
     */


    private final Stack<Integer> stack;
    private Integer min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        this.min = Math.min(this.min, x);
        this.stack.push(x);
    }

    public void pop() {
        Integer p = stack.pop();
        if(this.min.equals(p)) {
            this.min = Integer.MAX_VALUE;
            this.stack.forEach(i -> {
                this.min = Math.min(this.min, i);
            });
        }
    }

    public int top() {
        if(this.stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        if(this.stack.isEmpty()) return Integer.MIN_VALUE;
        return this.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
