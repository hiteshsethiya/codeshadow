package com.hitesh.test.leetcode.thirtydaychallenge;

import java.util.Arrays;

public class MoveZeroes {

    /*
     * Given an array nums, write a function to move all 0's to the end of it while maintaining
     * the relative order of the non-zero elements.
     *
     * Example:
     *
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     *
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */

    static public void moveZeroes(int[] nums) {
        int zeros = 0;
        for(int i : nums) {
            if(i == 0) zeros++;
        }
        if(zeros > 0 && zeros != nums.length) {
            int startShift = 0;
            for(int i = 0; i < nums.length; ++i) {
                if(nums[i] != 0) {
                    startShift = i;
                    break;
                }
            }

            for(int i = 0, j = startShift; j < nums.length; ++j) {
                if(nums[j] != 0) {
                    nums[i] = nums[j];
                    ++i;
                }
            }

            for(int j = nums.length - 1; j >= (nums.length - zeros); --j) {
                nums[j] = 0;
            }

        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{-1, -2, -3};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{0,1,0,3,12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{0,0,0,0,0};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{1,0,0,0,0};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
        a = new int[]{0,0,0,0,1};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

}
