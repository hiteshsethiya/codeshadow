package com.hitesh.test.leetcode.string;

import java.util.Stack;

public class DecodeString {

    /*
     * Given an encoded string, return its decoded string.
     *
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
     * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
     *
     * You may assume that the input string is always valid; No extra white spaces, square brackets are
     * well-formed, etc.
     *
     * Furthermore, you may assume that the original data does not contain any digits and that digits
     * are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
     *
     * Example 1:
     *
     * Input: s = "3[a]2[bc]"
     * Output: "aaabcbc"
     * Example 2:
     *
     * Input: s = "3[a2[c]]"
     * Output: "accaccacc"
     * Example 3:
     *
     * Input: s = "2[abc]3[cd]ef"
     * Output: "abcabccdcdcdef"
     * Example 4:
     *
     * Input: s = "abc3[cd]xyz"
     * Output: "abccdcdcdxyz"
     */

    public String decodeString(String s) {

        StringBuilder decodedString = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();

        for (int i = 0; i < s.length(); ) {

            char iChar = s.charAt(i);
            if (Character.isDigit(iChar)) {
                int count = 0;
                while (Character.isDigit(iChar)) {
                    count = (count * 10) + (iChar - '0');
                    ++i;
                    iChar = s.charAt(i);
                }
                countStack.push(count);
            }

            switch (iChar) {
                case '[': {
                    StringBuilder currentOperand = new StringBuilder();
                    iChar = s.charAt(++i);
                    while (Character.isAlphabetic(iChar)) {
                        currentOperand.append(iChar);
                        ++i;
                        iChar = s.charAt(i);
                    }
                    operandStack.push(currentOperand.toString());
                }
                break;
                case ']': {
                    // Make an operation
                    String operand = operandStack.pop();
                    int count = countStack.pop();
                    String result = repeat(operand, count);
                    if (operandStack.isEmpty()) {
                        decodedString.append(result);
                    } else {
                        operandStack.push(operandStack.pop() + result);
                    }
                    ++i;
                }
                break;
                default: {
                    decodedString.append(iChar);
                    ++i;
                }
            }
        }

        return decodedString.toString();
    }

    public String repeat(String value, int count) {
        if (value == null || value.isEmpty()) return value;
        StringBuilder sb = new StringBuilder();
        while (count-- > 0) sb.append(value);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[b4[F]c]"));
        System.out.println(new DecodeString().decodeString("100[leetcode]"));
        System.out.println(new DecodeString().decodeString("abc3[cd]xyz"));
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new DecodeString().decodeString("3[a2[bc]]"));
    }

}
