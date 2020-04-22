package com.hitesh.test.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /*
     * Given an array of integers and an integer k,
     * you need to find the total number of continuous subarrays whose sum equals to k.
     *
     * Example 1:
     * Input:nums = [1,1,1], k = 2
     * Output: 2
     * Note:
     * The length of the array is in range [1, 20,000].
     * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */

    static public int subarraySum(int[] nums, int k) {

        if(nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> sumToFrequency = new HashMap<>();
        int currentSum = 0, count = 0;

        for(int i = 0; i < nums.length; ++i) {
            currentSum += nums[i];
            if(currentSum == k) count++;
            if(sumToFrequency.containsKey(currentSum - k)) {
                count += sumToFrequency.get(currentSum - k);
            }
            sumToFrequency.put(currentSum, sumToFrequency.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
