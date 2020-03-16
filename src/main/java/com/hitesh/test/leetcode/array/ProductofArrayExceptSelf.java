package com.hitesh.test.leetcode.array;

import java.io.IOException;
import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        int p=1, N = nums.length;
        for(int i=0;i<N;++i) {
            a[i]=p;
            p*=nums[i];
        }

        p=1;
        for(int i=N-1;i>=0;--i) {
            a[i]*=p;
            p*=nums[i];
        }

        return a;
    }

    public static void main (String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
