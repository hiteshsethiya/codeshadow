package com.hitesh.test.leetcode.array;

public class SingleNumber {

    /*
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     *
     * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */

    static public int singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 1};
        System.out.println(singleNumber(a));
        a = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(a));
        a = new int[]{4,1,2,1,2, 3, 5, 6, 5, 6, 4, 4, 3};
        System.out.println(singleNumber(a));
    }

}
