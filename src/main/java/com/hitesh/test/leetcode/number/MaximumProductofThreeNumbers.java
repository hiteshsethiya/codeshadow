package com.hitesh.test.leetcode.number;

import java.util.Arrays;

public class MaximumProductofThreeNumbers {

    /*
     * Given an integer array, find three numbers whose product is maximum and output the maximum product.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     * Output: 6
     *
     *
     * Example 2:
     *
     * Input: [1,2,3,4]
     * Output: 24
     *
     *
     * Note:
     *
     * The length of the given array will be in range [3,10^4] and all elements are in the range [-1000, 1000].
     * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
     *
     */

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        if (nums.length == 3) {
            int maxProduct = 1;
            for (int i = 0; i < nums.length; ++i) {
                maxProduct *= nums[i];
            }
            return maxProduct;
        }
        Arrays.sort(nums);
        int negProd = 1;
        if (nums[1] < 0) {
            negProd = nums[0] * nums[1] * nums[nums.length - 1];
        }
        int posProd = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];

        return Math.max(negProd, posProd);
    }

}


