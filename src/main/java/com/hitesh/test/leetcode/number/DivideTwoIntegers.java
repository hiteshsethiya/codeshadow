package com.hitesh.test.leetcode.number;

public class DivideTwoIntegers {

    /*
     * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
     *
     * Return the quotient after dividing dividend by divisor.
     *
     * The integer division should truncate toward zero, which means losing its fractional part.
     * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
     *
     * Example 1:
     *
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Explanation: 10/3 = truncate(3.33333..) = 3.
     * Example 2:
     *
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * Explanation: 7/-3 = truncate(-2.33333..) = -2.
     * Note:
     *
     * Both dividend and divisor will be 32-bit signed integers.
     * The divisor will never be 0.
     * Assume we are dealing with an environment which could only store integers within
     * the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
     * assume that your function returns 231 − 1 when the division result overflows.
     */

    //36.5 MB, less than 6.06%, 1 ms, faster than 100.00%
    // Time complexity: O(LogN), Space O(1)
    static public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 0) return 0;
        int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(divisor == 1) return sign * dividend;
        int q = 0;
        while(dividend - divisor >= 0) {
            int cur = divisor;
            int step = 1;
            while(dividend - (cur + cur) > 0) {
                cur = cur + cur; // Increase by cur * step on every iteration.
                step += step;
            }
            q += step;
            dividend -= cur;
        }
        return sign * q;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1)); // Expected O/P: 2147483647
        System.out.println(divide(-2147483648, 1)); // Expected O/P: 2147483647
        System.out.println(divide(2147483647, 1)); // Expected O/P: 2147483647
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(12, 3));
        System.out.println(divide(100, 3));
    }

}
