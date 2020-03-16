package com.hitesh.test.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

    static public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; --i) {
            int d = digits[i] + carry + (i == digits.length - 1 ? 1 : 0);
            carry = d / 10;
            d %= 10;
            digits[i] = d;
        }
        if(carry > 0) {
            int[] a = new int[digits.length + 1];
            a[0] = carry;
            System.arraycopy(digits, 0, a, 1, a.length - 1);
            return a;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOne(a)));
    a = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(plusOne(a)));
    a = new int[]{9, 2, 9};
        System.out.println(Arrays.toString(plusOne(a)));
    }
}
