package com.hitesh.test.leetcode.string;

public class BuddyStrings {
    /*
     * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
     *
     *
     *
     * Example 1:
     *
     * Input: A = "ab", B = "ba"
     * Output: true
     * Example 2:
     *
     * Input: A = "ab", B = "ab"
     * Output: false
     * Example 3:
     *
     * Input: A = "aa", B = "aa"
     * Output: true
     * Example 4:
     *
     * Input: A = "aaaaaaabc", B = "aaaaaaacb"
     * Output: true
     * Example 5:
     *
     * Input: A = "", B = "aa"
     * Output: false
     *
     *
     * Note:
     *
     * 0 <= A.length <= 20000
     * 0 <= B.length <= 20000
     * A and B consist only of lowercase letters.
     */

    public static boolean isEmpty(String a) {
        return a == null || a.trim().isEmpty();
    }

    public static int search(char[] a, char v, int startIdx) {
        for (int i = startIdx; i < a.length; ++i) {
            if (v == a[i]) return i;
        }
        return -1;
    }

    public static void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public boolean buddyStringsSolution(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }

    static public boolean buddyStrings(String A, String B) {
        if (isEmpty(A) && isEmpty(B)) return false;
        if (isEmpty(A) && !isEmpty(B)) return false;
        if (isEmpty(B) && !isEmpty(A)) return false;
        if (A.length() != B.length()) return false;

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int swaps = 0;
        int[] letters = new int[26];
        for (int i = 0; i < a.length; ++i) {
            letters[a[i] - 'a']++;
            letters[b[i] - 'a']++;
            if (a[i] != b[i]) {
                int aIdx = search(a, b[i], i + 1);
                if (aIdx == -1) return false;
                swap(a, i, aIdx);
                swaps++;
                if(swaps > 1) return false;
            }
        }
        if (swaps == 0) {
            int c = 0;
            for (int i = 0; i < letters.length; ++i) {
                if (letters[i] > 0) {
                    c++;
                }
            }
            if(c == 1 && a.length > 1) return true;
            if(c == a.length) return false;
            if (a.length > 2) return true;
        }
        return swaps == 1;
    }

    public static void exec(String a, String b) {
//        System.out.println("a -> " + a + " - b -> " + b + " " + buddyStrings(a, b));
        System.out.println(a + " , " + b + " = " + buddyStrings(a, b));
    }

    public static void main(String[] ar) {
        exec("abcd", "abcd");
        exec("aba", "aba");
        exec("abab", "abab");
        exec("dd", "dd");
        exec("abcd", "badc");
        exec("ab", "ba");
        exec("ab", "ab");
        exec("aa", "aa");
        exec("aaaaaaabc", "aaaaaaacb");
        exec("", "aa");
        exec("aa", "");
        exec("aaasdf", "asdf");
    }

}
