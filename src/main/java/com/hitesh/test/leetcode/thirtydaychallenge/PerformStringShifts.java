package com.hitesh.test.leetcode.thirtydaychallenge;

public class PerformStringShifts {

    /*
     * You are given a string s containing lowercase English letters, and a matrix shift,
     * where shift[i] = [direction, amount]:
     *
     * direction can be 0 (for left shift) or 1 (for right shift).
     * amount is the amount by which string s is to be shifted.
     * A left shift by 1 means remove the first character of s and append it to the end.
     * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
     * Return the final string after all operations.

     * Example 1:
     *
     * Input: s = "abc", shift = [[0,1],[1,2]]
     * Output: "cab"
     * Explanation:
     * [0,1] means shift to left by 1. "abc" -> "bca"
     * [1,2] means shift to right by 2. "bca" -> "cab"
     * Example 2:
     *
     * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
     * Output: "efgabcd"
     * Explanation:
     * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
     * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
     * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
     * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 100
     * s only contains lower case English letters.
     * 1 <= shift.length <= 100
     * shift[i].length == 2
     * 0 <= shift[i][0] <= 1
     * 0 <= shift[i][1] <= 100
     */

    static public String shift(String s, boolean left, int n) {
        if (n == 0 || s == null || s.trim().isEmpty()) return s;
        n = Math.abs(n);
        n = n % s.length();
        s = s.trim();
        String x, y;
        if (left) {
            x = s.substring(0, n);
            y = s.substring(n);
        } else {
            x = s.substring(0, s.length() - n);
            y = s.substring(s.length() - n);
        }
        return y + x;
    }

    static public String stringShift(String s, int[][] shift) {
        int leftShifts = 0, rightShifts = 0;
        for (int[] ints : shift) {
            boolean left = ints[0] == 0;
            if (left) leftShifts += ints[1];
            else rightShifts += ints[1];
        }
        boolean left = leftShifts - rightShifts > 0;
        return shift(s, left, leftShifts - rightShifts);
    }


    public static void execute(String s, int[][] shift, String exp) {
        String ans = stringShift(s, shift);
        System.out.println("Inp : " + s);
        System.out.println("Ans : " + ans);
        System.out.println("Exp : " + exp);
        System.out.println(exp.equals(ans));
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0,1},{1,2}
        };
        execute("abc", a, "cab");
        a = new int[][]{
                {1,1},{1,1},{0,2},{1,3}
        };
        execute("abcdefg", a, "efgabcd");
        a = new int[][]{};
        execute("abcdefg", a, "abcdefg");
        a = new int[][]{
                {0, 0}, {0, 0}
        };
        execute("abcdefg", a, "abcdefg");
        a = new int[][]{
                {0, 1}, {1, 1}
        };
        execute("abcdefg", a, "abcdefg");
    }
}
