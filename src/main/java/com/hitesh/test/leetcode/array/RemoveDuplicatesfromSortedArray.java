package com.hitesh.test.leetcode.array;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

    public static void shift(int[] a, int s, int e) {
        for(int i = s, j = i + 1; j < e; ++j, ++i) {
            a[i] = a[j];
        }
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int length = 1, r = nums[0];
        for(int i = 1, s = 1; i < nums.length; ++i) {
            if(r != nums[i]) {
                length++;
                r = nums[i];
                nums[s++] = r;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        a = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        a = new int[]{0,1,2,3,4};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        a = new int[]{0,1,2,3,4, 4, 4, 4, 4, 5, 5, 6, 7};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        a = new int[]{0,0,0,0,0};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        a = new int[]{0,0,1,1,1};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
        a = new int[]{};
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }

}
