package com.hitesh.test.leetcode.string;

public class ReverseWordsInAStringII {

    /**
     * Given an input string , reverse the string word by word.
     *
     * Example:
     *
     * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
     * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
     *
     * Note:
     *
     *     A word is defined as a sequence of non-space characters.
     *     The input string does not contain leading or trailing spaces.
     *     The words are always separated by a single space.
     *
     * Follow up: Could you do it in-place without allocating extra space?
     */

    public void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }

    public void reverseWords(char[] s) {
        int n = s.length;
        for(int i = 0; i < n / 2; ++i) {
            swap(s, i, n - 1 - i);
        }
        for(int i = 0, j = i; i < n; i = j) {
            while(j < n && s[j] != ' ') j++;
            int k = j - 1;
            j++;
            while(i <= k) {
                swap(s, i++, k--);
            }
        }
    }

    public static void execute(char[] s, String expected) {
        new ReverseWordsInAStringII().reverseWords(s);
        System.out.println(s);
        System.out.println(new String(s).equals(expected));
    }

    public static void main(String[] args) {
        execute(new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'}, "blue is sky the");
    }

}
