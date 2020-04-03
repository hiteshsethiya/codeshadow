package com.hitesh.test.leetcode.array;

import java.util.*;

public class ContinuousSubarraySum {

    /*
     * Given a list of non-negative numbers and a target integer k,
     * write a function to check if the array has a continuous subarray of
     * size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
     *
     * Example 1:
     *
     * Input: [23, 2, 4, 6, 7],  k=6
     * Output: True
     * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
     * Example 2:
     *
     * Input: [23, 2, 6, 4, 7],  k=6
     * Output: True
     * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
     *
     *
     * Note:
     *
     * The length of the array won't exceed 10,000.
     * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
     */

    static public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i < sum.length; ++i) {
            sum[i] += sum[i - 1] + nums[i - 1];
            //if 2 consecutive 0s are in the input array then return true. Weird but required.
            if(i > 1 && nums[i - 2] == 0 && nums[i - 1] == 0) return true;
        }
        k = Math.abs(k);
        if(k == 0) return false;
        if(k == 1) return true; // because you can arrive at any of nums[i] through 1. 1 * 1, 1 * 2, 1 * 3...

        Map<Integer, Integer> sumIdxs = new HashMap<>();
        for(int i = 0; i < sum.length; ++i) {
            for(int j = 1; j <= (sum[i] / k); ++j) {
                int target = j * k;
                int needed = sum[i] - target;
                if(i - sumIdxs.getOrDefault(needed, Integer.MAX_VALUE) >= 2) return true;
            }
            if(!sumIdxs.containsKey(sum[i])) sumIdxs.put(sum[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 0};
        int k = 0;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{1, 1};
        k = 2;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{23, 0, 0};
        k = 6; // Expected output is true;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{0, 0, 0};
        k = 1;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{0, 0, 0};
        k = 2;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{23, 2, 6, 4, 7};
        k = 6;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{23, 2, 4, 6, 7};
        k = 24;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{23, 2, 6, 4, 7};
        k = 0;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{23, 2, 4, 6, 7};
        k = 6;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{23, 2, 4, 6, 7};
        k = 42;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
        a = new int[]{23, 2, 4, 6, 7};
        k = 142;
        System.out.println(Arrays.toString(a) + ", k = " + k + checkSubarraySum(a, k));
    }

}
