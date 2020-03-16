package com.hitesh.test.leetcode.array;

public class AddStrings {

    public static String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        if(num1.isEmpty()) return num2;
        if(num2.isEmpty()) return num1;
        num1 = num1.trim();
        num2 = num2.trim();
        int minLen = num1.length();
        if(num1.length() > num2.length()) {
            minLen = num2.length();
            String t = num2;
            num2 = num1;
            num1 = t;
        }

        int carry = 0;
        StringBuilder r = new StringBuilder();
        int sign1 = num1.startsWith("-") ? -1 : 1;
        int sign2 = num2.startsWith("-") ? -1  : 1;
        int sign = sign1 * sign2;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0; --i, --j) {
            if(num1.charAt(i) != '-' && num2.charAt(j) != '-') {
                int d = ((num1.charAt(i) - 48) * sign) + (num2.charAt(j) - 48) + carry;
                carry = 0;
                if(d > 9) {
                    carry = (d / 10);
                }
                d %= 10;
                r.insert(0, d);
            }
        }

        if(num2.length() > minLen) {
            String remainingDigits = num2.substring(0, num2.length() - minLen);
            for(int i = remainingDigits.length() - 1; i >= 0 ; --i) {
                int d = ((remainingDigits.charAt(i) - 48) * sign) + carry;
                carry = 0;
                if(d > 9) {
                    carry = (d / 10);
                }
                d %= 10;
                r.insert(0, d);
            }
        }

        if(carry > 0){
            r.insert(0, carry);
        }
        return r.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("9", "99"));
        System.out.println(addStrings("6994", "36"));
        System.out.println(addStrings("999", "999"));
        System.out.println(addStrings("15000000", "15"));
        System.out.println(addStrings("15000029", "15"));
        System.out.println(addStrings("9", "15"));
        System.out.println(addStrings("15", "9"));
        System.out.println(addStrings("15", "15"));
        System.out.println(addStrings("15", "150"));
        System.out.println(addStrings("150", "15"));
        System.out.println(addStrings("150", ""));
        System.out.println(addStrings("", "12"));
    }

}
