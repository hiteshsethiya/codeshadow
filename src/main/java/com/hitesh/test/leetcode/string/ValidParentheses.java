package com.hitesh.test.leetcode.string;

import java.util.*;

public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     *
     * Example 2:
     *
     * Input: "()[]{}"
     * Output: true
     *
     * Example 3:
     *
     * Input: "(]"
     * Output: false
     *
     * Example 4:
     *
     * Input: "([)]"
     * Output: false
     *
     * Example 5:
     *
     * Input: "{[]}"
     * Output: true
     */

    static public boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;
        Map<Character, Character> c = new HashMap<>();
        c.put('(', ')');
        c.put('{', '}');
        c.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            if(c.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else if(stack.isEmpty() || !c.getOrDefault(stack.pop(), '-').equals(s.charAt(i))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid(""));
        System.out.println(isValid("()(((((()"));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

}
