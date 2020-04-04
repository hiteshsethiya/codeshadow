package com.hitesh.test.leetcode.thirtydaychallenge;

public class MaximumSubarray {

    /*
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and return its sum.
     *
     * Example:
     *
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Follow up:
     *
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
     * which is more subtle.
     */

    static public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE, max_ending_here = 0, max_so_far = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            max_ending_here = Math.max(num + max_ending_here, 0);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        if (max_so_far == 0) return max;
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
        a = new int[]{-1, -2, -3};
        System.out.println(maxSubArray(a));
    }

}
