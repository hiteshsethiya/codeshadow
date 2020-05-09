package com.hitesh.test.leetcode.array;

public class ContiguousArray {

    /*
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
     *
     * Example 1:
     * Input: [0,1]
     * Output: 2
     * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     * Example 2:
     * Input: [0,1,0]
     * Output: 2
     * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     * Note: The length of the given binary array will not exceed 50,000.
     */

    static public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int z = 0, o = 0;
        for (int i : nums) {
            if (i == 0) z++;
            else o++;
        }
        return (z + o) - Math.abs(z - o);
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 1, 0, 1, 1, 1, 0};
        System.out.println(findMaxLength(a)); // 4
        a = new int[]{0, 1, 0};
        System.out.println(findMaxLength(a));
        a = new int[]{0, 1};
        System.out.println(findMaxLength(a));
        a = new int[]{0, 0, 0, 0};
        System.out.println(findMaxLength(a));
        a = new int[]{1, 1, 1, 1};
        System.out.println(findMaxLength(a));
        a = new int[]{1};
        System.out.println(findMaxLength(a));
        a = new int[]{0};
        System.out.println(findMaxLength(a));
        a = new int[]{0, 0, 0, 0, 1, 1, 1};
        System.out.println(findMaxLength(a));
    }

}
