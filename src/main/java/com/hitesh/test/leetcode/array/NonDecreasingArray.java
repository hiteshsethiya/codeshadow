package com.hitesh.test.leetcode.array;

import java.util.Arrays;

public class NonDecreasingArray {

    /**
     * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
     * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
     *
     * Example 1:
     * Input: [4,2,3]
     * Output: True
     * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
     *
     * Example 2:
     * Input: [4,2,1]
     * Output: False
     * Explanation: You can't get a non-decreasing array by modify at most one element.
     * Note: The n belongs to [1, 10,000].
     */

    static public boolean check2(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        int c = 0, max = Integer.MIN_VALUE, min = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            if(min > nums[i]) {
                c++;
                min = nums[i - 1];
            }
            if(max > nums[i]) {
                c++;
                max = nums[i];
            }
            if(c > 1)
                return false;
        }
        return true;
    }

    static public boolean checkPossibilitya(int[] a) {
        int c = 0;
        int[] lmin = new int[a.length];
        int[] lmax = new int[a.length];
        lmin[0] = a[0];
        lmax[0] = a[0];
        for(int i = 1; i < a.length; ++i) {
            lmin[i] = Math.min(a[i], lmin[i - 1]);
            lmax[i] = Math.max(a[i], lmax[i - 1]);
        }
        for(int i = 1; i < a.length; ++i) {
            if(lmin[i] > a[i] || lmax[i] > a[i]) {
                c++;
            }
            if(c > 2) return false;
        }
        return true;
    }

    static public boolean checkPossibility(int[] nums) {
        int p = -1;
        for(int i = 0; i < nums.length - 1; ++i) {
            if(nums[i] > nums[i+1]) {
                if(p != -1) return false;
                p = i;
            }
        }
        return (p == -1 || p == 0 || p == nums.length-2 || nums[p-1] <= nums[p+1] || nums[p] <= nums[p+2]);
    }

    public static boolean check(int[] a) {
        int c = 0;
        for(int i = 0; i < a.length; ++i) {
            for(int j = i + 1; j < a.length; ++j) {
                if(a[i] > a[j]) {
                    c++;
                    break;
                }
            }
            if(c > 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2, 3, -1, 4, 5, 6};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
        a = new int[]{-2, -1, -4, 5, 6};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
        a = new int[]{-2, -1, 4, 2, 3};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
        a = new int[]{3, 4, 2, 3};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
        a = new int[]{4, 2, 1};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
        a = new int[]{4, 2, 3};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
        a = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
        a = new int[]{3, 2, 1};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
        a = new int[]{1, 2, 3, 4, 6, 10, 9, 9, 8};
        System.out.println(Arrays.toString(a) + " -> " + checkPossibility(a));
    }

}
