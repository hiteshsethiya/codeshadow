package com.hitesh.test.leetcode.dp;

public class IsSubsequence {

    /*
     * Given a string s and a string t, check if s is subsequence of t.
     *
     * A subsequence of a string is a new string which is formed from the original
     * string by deleting some (can be none) of the characters without disturbing the relative
     * positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
     *
     * Follow up:
     * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
     *
     * Credits:
     * Special thanks to @pbrother for adding this problem and creating all test cases.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     * Example 2:
     *
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     *
     *
     * Constraints:
     *
     * 0 <= s.length <= 100
     * 0 <= t.length <= 10^4
     * Both strings consists only of lowercase characters.
     */

    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int i = 0, j = 0;
        for(; j < t.length() && i < s.length(); ++j) {
            if(t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        return  i == s.length() && j <= t.length();
    }

    public static void execute(String s, String t, boolean ans) {
        boolean o = new IsSubsequence().isSubsequence(s, t);
//        System.out.println(o);
        System.out.println(o == ans);
    }

    public static void main(String[] args) {
        execute("abc", "ahbgdc", true);
        execute("axc", "ahbgdc", false);
        execute("aaaaaaa", "aaaaaa", false);
        execute("aaaaaaa", "aaaaaaa", true);
    }

}
