package com.hitesh.test.leetcode.string;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        if(s == null || s.isEmpty()) return s;
        Stack<Integer> oStack = new Stack<>();
        StringBuilder output = new StringBuilder(s);
        for(int i = 0; i < output.length(); ++i) {
            char ic = output.charAt(i);
            switch (ic) {
                case '(': {
                    oStack.push(i);
                } break;
                case ')': {
                    if(!oStack.isEmpty()) {
                        oStack.pop();
                    } else {
                        output.replace(i, i + 1, "*");
                    }
                } break;
            }
        }
        while(!oStack.isEmpty()) {
            output.setCharAt(oStack.pop(), '*');
        }

        return output.toString().replaceAll("\\*", "");
    }

    public static void execute(String s, String exp) {
        String o = new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s);
        System.out.println(o);
        System.out.println(o.equals(exp));
    }

    public static void main(String[] args) {
        execute("(a(b(c(d)", "abc(d)");
        execute("lee(t(c)o)de)", "lee(t(c)o)de");
        execute("a)b(c)d", "ab(c)d");
        execute("))((", "");
        execute("(a(b(c)d)", "a(b(c)d)");
    }

}
