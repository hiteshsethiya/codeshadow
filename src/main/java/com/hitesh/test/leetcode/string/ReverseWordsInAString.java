package com.hitesh.test.leetcode.string;

public class ReverseWordsInAString {

    public void swap(StringBuilder s, int i, int j) {
        char t = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, t);
    }


    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.trim());
        sb.reverse();
        int n = sb.length();
        for (int i = 0, j = i; i < n; i = j) {
            while (j < n && sb.charAt(j) != ' ') j++;
            int k = j - 1;
            while (i <= k) {
                swap(sb, i++, k--);
            }
            ++j;
            while (j < n && sb.charAt(j) == ' ') sb.setCharAt(j++, '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }

    public static void execute(String s, String expected) {
        String out = new ReverseWordsInAString().reverseWords(s);
        System.out.println(out);
        System.out.println(out.equals(expected));
    }

    public static void main(String[] args) {
        execute("a good   example", "example good a");
        execute("  hello world!  ", "world! hello");
        execute("the sky is blue", "blue is sky the");
    }
}
