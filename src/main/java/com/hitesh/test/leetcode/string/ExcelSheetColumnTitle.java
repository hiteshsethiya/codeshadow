package com.hitesh.test.leetcode.string;

public class ExcelSheetColumnTitle {
    static public String convertToTitle(int n) {
        if(n < 0) return "";
        String o = "";
        while(n > 0) {
            n--;
            char l = (char) ((n % 26) + 'A');
            n /= 26;
            o = l + o;
        }
        return o;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(29));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(703));
//        System.out.println(convertToTitle(7010));
    }
}
