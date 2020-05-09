package com.hitesh.test.leetcode.string;

public class LongestPalindromicSubstring {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * <p>
     * Example 1:
     * <p>
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     * <p>
     * Input: "cbbd"
     * Output: "bb"
     */

    public static int palindrome(String s, int i, int j) {
        if (i > j) return 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }
        return j - i - 1;
    }

    static public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length() && (end - start < s.length()); ++i) {
            int evenLength = palindrome(s, i, i + 1);
            int oddLength = palindrome(s, i, i);
            int len = Math.max(evenLength, oddLength);
            if(end - start < len) {
                start = i - (len - 1) / 2;
                end = i + (len / 2) + 1;
            }
        }
        return s.substring(start, end);
    }

    public static void execute(String s, String exp) {
        String o = longestPalindrome(s);
        System.out.println("Input : " + s + " o/p: " + o + " Pass: " + o.equals(exp));
    }

    public static void main(String[] args) {
        execute("abcd", "a");
        execute("babad", "bab");
        execute("babab", "babab");
        execute("abba", "abba");
    }

}
