package com.hitesh.test.leetcode.thirtydaychallenge;

import java.util.Stack;

public class ValidParenthesisString {

    /*
     * Given a string containing only three types of characters: '(', ')' and '*',
     * write a function to check whether this string is valid. We define the validity of a string by these rules:
     *
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
     *
     * An empty string is also valid.
     * Example 1:
     * Input: "()"
     * Output: True
     *
     * Example 2:
     * Input: "(*)"
     * Output: True
     *
     * Example 3:
     * Input: "(*))"
     * Output: True
     *
     * Note:
     * The string size will be in the range [1, 100].
     */

    static public boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) return true;

        Stack<Integer> openBraces = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case '(':
                    openBraces.push(i);
                    break;
                case '*':
                    stars.push(i);
                    break;
                case ')': {
                    if (openBraces.isEmpty()) {
                        if (stars.isEmpty() || stars.peek() > i) return false;
                        stars.pop();
                    } else {
                        openBraces.pop();
                    }
                }
                break;
            }
        }
        while (!openBraces.isEmpty() && !stars.isEmpty() && stars.peek() > openBraces.peek()) {
            stars.pop(); openBraces.pop();
        }
        return openBraces.isEmpty();
    }

    public static void execute(String inp, boolean exp) {
        System.out.println(inp);
        boolean ans = checkValidString(inp);
        System.out.println(ans == exp);
    }

    public static void main(String[] args) {
        execute("(())((())()()(*)(*()(())())())()()((()())((()))(*", false);
        execute("(*(*(*(*)*)*", true);
        execute("((*(*(*(*)*)*", true);
        execute("((((((", false);
        execute("))))))", false);
        execute("))))))******", false);
        execute("((((((******", true);
        execute("******", true);
        execute("*(**(**(*(", false);
        execute("*(**(**(*()", true);
    }

}
