package com.hitesh.test.leetcode.dp;

public class MaximumProductSubarray {

    /*
     * Given an integer array nums, find the contiguous subarray within an array
     * (containing at least one number) which has the largest product.
     *
     * Example 1:
     *
     * Input: [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * Example 2:
     *
     * Input: [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     */

    public int maxProduct(int[] nums) {

        int maxEndingSoFar = Integer.MIN_VALUE;
        int maxEndingHere = nums[0], minEndingHere = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            int currentMin = Math.min(maxEndingHere * nums[i], Math.min(minEndingHere * nums[i], nums[i]));
            maxEndingHere = Math.max(maxEndingHere * nums[i], Math.max(minEndingHere * nums[i], nums[i]));
            minEndingHere = currentMin;
            maxEndingSoFar = Math.max(maxEndingSoFar, maxEndingHere);
        }
        return maxEndingSoFar;
    }

    public static void execute(int[] nums, int ans) {
        int result = new MaximumProductSubarray().maxProduct(nums);
        System.out.println(result + " -> " + (result == ans));
    }

    public static void main(String[] args) {
        execute(new int[]{2, -5, -2, -4, 3}, 24);
        execute(new int[]{0, 0, 0, -1, -1}, 1);
        execute(new int[]{1, 2, 3, 4, 5}, 120);
        execute(new int[]{0, 0, 0, -1, -1}, 1);
        execute(new int[]{2, 3, -2, 4, 2}, 8);
        execute(new int[]{2, 3, -2, 4, 2, -2}, 192);
        execute(new int[]{2, 3, 0, 4, 2, -2}, 8);
        execute(new int[]{-2, 0, -1}, 0);
        execute(new int[]{2, 3, -2, 4}, 6);
    }

}
