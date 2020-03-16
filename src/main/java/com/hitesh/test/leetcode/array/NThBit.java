package com.hitesh.test.leetcode.array;

public class NThBit {

    public static String decimalToBinary(int n) {
        StringBuilder str = new StringBuilder();

        if (n == 0) {
            str.append("0");
        }

        while (n > 0) {
            str.append(n % 2);
            n /= 2;
        }
        return new StringBuilder(str.toString()).reverse().toString();
    }

    public static int fourthBit(int number) {
        String s = decimalToBinary(number);
        if(s.length() > 3)
        return s.charAt(3) - '0';
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(fourthBit(77));
        System.out.println(fourthBit(32));
        System.out.println(fourthBit(0));
        System.out.println(fourthBit(1));
        System.out.println(fourthBit(12));
    }
}
