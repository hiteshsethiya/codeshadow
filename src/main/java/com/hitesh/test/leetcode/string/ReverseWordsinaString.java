package com.hitesh.test.leetcode.string;

public class ReverseWordsinaString {

    /*
     * Given an input string, reverse the string word by word.
     *
     *
     *
     * Example 1:
     *
     * Input: "the sky is blue"
     * Output: "blue is sky the"
     * Example 2:
     *
     * Input: "  hello world!  "
     * Output: "world! hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * Example 3:
     *
     * Input: "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     *
     * Note:
     *
     * A word is defined as a sequence of non-space characters.
     * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
     * You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     *
     * Follow up:
     *
     * For C programmers, try to solve it in-place in O(1) extra space.
     */

    static void swap(StringBuilder s, int i, int j) {
        char t = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, t);
    }

    static public String reverseWords(String s) {
        if(s == null || s.isEmpty()) return s;
        s = s.trim();
        String[] words = s.split(" ");
        StringBuilder o = new StringBuilder();
        for(int j = words.length - 1; j >= 0; --j) {
            if(!words[j].trim().isEmpty()) {
                o.append(words[j]).append(" ");
            }
        }
        return o.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(s + " -> " + reverseWords(s));
        s = "the sky is blue";
        System.out.println(s + " -> " + reverseWords(s));
        s = "  hello world!  ";
        System.out.println(s + " -> " + reverseWords(s));
    }

}
