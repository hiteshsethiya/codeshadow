package com.hitesh.test.leetcode.number;

public class PalindromeNumber {

    /**
     * Determine whether an integer is a palindrome.
     * An integer is a palindrome when it reads the same backward as forward.
     * <p>
     * Example 1:
     * Input: 121
     * Output: true
     * <p>
     * Example 2:
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * <p>
     * Example 3:
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     * Follow up:
     * <p>
     * Could you solve it without converting the integer to a string?
     */

    static int countDigits(int x) {
        int c = 0;
        while (x > 0) {
            x /= 10;
            c++;
        }
        return c;
    }

    static public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int c = countDigits(x);
        double fLimit = Math.pow(10, c - 1);
        int f = x;
        while (x > 0) {
            int i = (int) (f / fLimit);
            f %= fLimit;
            fLimit /= 10;
            int j = x % 10;
            x /= 10;
            if (i != j) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(12));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(100000001));
    }
}
