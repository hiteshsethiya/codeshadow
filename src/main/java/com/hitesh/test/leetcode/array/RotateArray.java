package com.hitesh.test.leetcode.array;

import java.util.Arrays;

public class RotateArray {

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] =  a[j];
        a[j] = t;
    }

    public static void rotate(int[] a, int i, int j) {
        for(;i <= j; ++i, --j) {
            swap(a, i, j);
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        rotate(a, 4);
        System.out.println(Arrays.toString(a));
        a = new int[]{1, 2, 3, 4};
        rotate(a, 3);
        System.out.println(Arrays.toString(a));
        a = new int[]{1, 2, 3, 4};
        rotate(a, 2);
        System.out.println(Arrays.toString(a));
        a = new int[]{1, 2, 3, 4};
        rotate(a, 1);
        System.out.println(Arrays.toString(a));
        a = new int[]{1, 2, 3, 4};
        rotate(a, 0);
        System.out.println(Arrays.toString(a));
    }

}
