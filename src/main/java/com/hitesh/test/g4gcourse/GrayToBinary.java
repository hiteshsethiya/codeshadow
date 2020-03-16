package com.hitesh.test.g4gcourse;

public class GrayToBinary {

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

    public static int binaryToDecimal(String bin) {
        int n = 0;
        for (int i = 0, j = bin.length() - 1; j >= 0; ++i, --j) {
            if (bin.charAt(j) == '1') {
                n += Math.pow(2, i);
            }
        }
        return n;
    }

    public static char xorc(char a, char b) {
        return a == b ? '0' : '1';
    }

    public static char flip(char a) {
        return a == '1' ? '0' : '1';
    }

    public static String binaryToGray(String binary) {
        StringBuilder gray = new StringBuilder(binary.charAt(0) + "");
        for (int i = 1; i < binary.length(); ++i) {
            gray.append(xorc(binary.charAt(i - 1), binary.charAt(i)));
        }
        return gray.toString();
    }

    public static String grayToBinaryC(String gray) {
        StringBuilder binary = new StringBuilder(gray.charAt(0) + "");
        for (int i = 1; i < gray.length(); ++i) {

            if (gray.charAt(i) == '0') {
                binary.append(binary.charAt(i - 1));
            } else {
                binary.append(flip(binary.charAt(i - 1)));
            }
        }
        return binary.toString();
    }

    static int grayToBinary(int n) {

        // Your code here
        String gray = decimalToBinary(n);
        String bin = grayToBinaryC(gray);
        return binaryToDecimal(bin);
    }

    public static void main(String[] args) {
        System.out.println(grayToBinary(4));
        System.out.println(grayToBinary(15));
        System.out.println(grayToBinary(0));
    }

}
