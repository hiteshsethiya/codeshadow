package com.hitesh.test.leetcode.string;

public class StringToInteger {

    public static int myAtoi(String str) {
        int total = 0, i = 0, sign = 1;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        for (; i < str.length(); ++i) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                sign = str.charAt(i) == '+' ? 1 : -1;
                ++i;
            }
            if (i >= str.length()) break;
            if (!Character.isDigit(str.charAt(i))) {
                break;
            }
            if (total > Integer.MAX_VALUE / 10 || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < str.charAt(i) - '0')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            total *= 10;
            total += str.charAt(i) - '0';
        }
        return total * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("    0000000000000   "));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("3.1234"));
    }
}
