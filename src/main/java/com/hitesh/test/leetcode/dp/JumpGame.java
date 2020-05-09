package com.hitesh.test.leetcode.dp;

import java.util.Arrays;

public class JumpGame {

    /*
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     * Example 1:
     *
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     *              jump length is 0, which makes it impossible to reach the last index.
     */

    static public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        if(nums.length == 1) return true;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < nums.length; ++i) {
            for(int j = 0; j < i; ++j) {
                if(j + nums[j] >= i) {
                    if(dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[nums.length - 1] != Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,1,0,4};
        System.out.println(canJump(a));
        a = new int[]{2,3,1,1,4};
        System.out.println(canJump(a));
    }

}
