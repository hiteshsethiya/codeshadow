package com.hitesh.test.leetcode.binary;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for(int i : nums) {
            if(i == 1) count++;
            else count = 0;
            max = Math.max(max, count);
        }
        return max;
    }

}
