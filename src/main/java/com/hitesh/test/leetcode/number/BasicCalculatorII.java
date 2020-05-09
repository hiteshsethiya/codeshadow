package com.hitesh.test.leetcode.number;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BasicCalculatorII {
    /*
     * Implement a basic calculator to evaluate a simple expression string.
     *
     * The expression string contains only non-negative integers, +, -, *, / operators
     * and empty spaces . The integer division should truncate toward zero.
     *
     * Example 1:
     *
     * Input: "3+2*2"
     * Output: 7
     * Example 2:
     *
     * Input: " 3/2 "
     * Output: 1
     * Example 3:
     *
     * Input: " 3+5 / 2 "
     * Output: 5
     * Note:
     *
     * You may assume that the given expression is always valid.
     * Do not use the eval built-in library function.
     */

    static public int operation(char o, int a, int b) {
        switch (o) {
            case '/':
                return a / b;
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '-':
                return b < 0 ? a + b : a - b;
        }
        return a;
    }

    static public String getNumber(String s, int i) {
        StringBuilder n = new StringBuilder();
        for(;i < s.length() && Character.isDigit(s.charAt(i)); ++i) {
            n.append(s.charAt(i));
        }
        return n.toString();
    }

    private static final Map<Character, Integer> priority = new HashMap<>();

    static {
        priority.put('/', 0);
        priority.put('*', 0);
        priority.put('-', 2);
        priority.put('+', 3);
    }

    static public int calculate(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        s = s.trim().replaceAll(" ", "");
        Stack<Integer> digits = new Stack<>();
        Stack<Character> operations = new Stack<>();
        for (int i = 0; i < s.length();) {
            if(Character.isDigit(s.charAt(i))) {
                String n = getNumber(s, i);
                digits.push(Integer.parseInt(n));
                i += n.length();
            } else {
                char o = s.charAt(i);
                if(!operations.isEmpty() && priority.get(operations.peek()) <= priority.get(o)) {
                     char prevOp = operations.pop();
                     int b = digits.pop();
                     int a = digits.pop();
                    if(!operations.isEmpty() && operations.peek() == '-') {
                        a *= -1;
                        operations.pop();
                        operations.push('+');
                    }
                     digits.push(operation(prevOp, a, b));
                }
                operations.push(o);
                ++i;
            }
        }
        while (digits.size() != 1) {
            int b = digits.pop(), a = digits.pop();
            char cOp = operations.pop();
            if(!operations.isEmpty() && operations.peek() == '-') {
                a *= -1;
                operations.pop();
                operations.push('+');
            }
            digits.push(operation(cOp, a, b));
        }
        return digits.peek();
    }

    public static void execute(String inp, int exp) {
        int ans = calculate(inp);
        System.out.println("Ans : " + ans);
        System.out.println(exp == ans);
    }

    public static void main(String[] args) {
        execute("282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024", 4067);
        execute("1*2+3*4-5*6+7*8-9*10", -50);
        execute("1*2-3/4+5*6-7*8+9/10", -24);
        execute("14/3*2", 8);
        execute("1-1+1", 1);
        execute("31+2*2/3", 32);
        execute("31+2*2", 35);
        execute("3+2*2", 7);
        execute(" 3/2 ", 1);
        execute(" 3+5 / 2 ", 5);
    }
}
