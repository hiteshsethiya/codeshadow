package com.hitesh.test.leetcode.thirtydaychallenge;

public class BackspaceStringCompare {

    /*
     * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
     *
     * Example 1:
     *
     * Input: S = "ab#c", T = "ad#c"
     * Output: true
     * Explanation: Both S and T become "ac".
     * Example 2:
     *
     * Input: S = "ab##", T = "c#d#"
     * Output: true
     * Explanation: Both S and T become "".
     * Example 3:
     *
     * Input: S = "a##c", T = "#a#c"
     * Output: true
     * Explanation: Both S and T become "c".
     * Example 4:
     *
     * Input: S = "a#c", T = "b"
     * Output: false
     * Explanation: S becomes "c" while T becomes "b".
     * Note:
     *
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S and T only contain lowercase letters and '#' characters.
     * Follow up:
     *
     * Can you solve it in O(N) time and O(1) space?
     */

    static public boolean isAlpha(char cha) {
        return ('a' <= cha && cha <= 'z') || ('A' <= cha && cha <= 'Z');
    }

    static public String backSpace(String s) {
        if(s == null || s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder(s);
        for(int i = -1, j, k = 0; k < s.length(); ++k) {
            if(sb.charAt(k) == '#') {
                j = k;
                if(i >= 0 && i < j) {
                    sb.replace(i, i + 1, "#");
                    --i;
                    while(i >= 0 && sb.charAt(i) == '#') i--;
                }
            } else if(isAlpha(sb.charAt(k))) {
                i = k;
            }
        }
        return sb.toString();
    }

    static public boolean equal(String s, String t) {
        return s.replaceAll("#", "").equals(t.replaceAll("#", ""));
    }

    static public boolean backspaceCompare(String S, String T) {
        return equal(backSpace(S), backSpace(T));
    }

    public static void main(String[] args) {
        String s = "bxj##tw";
        String t = "bxo#j##tw";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "isfcow#";
        t = "isfco#w#";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "abcd";
        t = "abcd";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "asdf";
        t = "adsf";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "asdf#####dfg";
        t = "adsf######dfg";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "asdf#####dfg#g";
        t = "adsf######dfgg#";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "ab#c";
        t = "ad#c";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "ab##";
        t = "c#d#";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "a##c";
        t = "#a#c";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
        s = "######";
        t = "###";
        System.out.println("s -> " + s + " t -> " + t + " = " + backspaceCompare(s, t));
    }

}
