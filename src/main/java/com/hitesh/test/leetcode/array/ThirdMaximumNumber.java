package com.hitesh.test.leetcode.array;

import java.util.Arrays;

public class ThirdMaximumNumber {

    /*
     * Given a non-empty array of integers, return the third maximum number in this array.
     * If it does not exist, return the maximum number. The time complexity must be in O(n).
     *
     * Example 1:
     * Input: [3, 2, 1]
     * Output: 1
     * Explanation: The third maximum is 1.
     *
     * Example 2:
     * Input: [1, 2]
     * Output: 2
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     *
     * Example 3:
     * Input: [2, 2, 3, 1]
     * Output: 1
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     */

    static public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Integer[] m = new Integer[3];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < m.length; ++j) {
                if (m[j] == null || nums[i] > m[j]) {
                    System.arraycopy(m, j, m, j + 1, m.length - 1 - j);
                    m[j] = nums[i];
                    break;
                } else if (nums[i] == m[j]) break;
            }
        }
        return m[2] == null ? m[0] : m[2];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, -2147483648};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
        a = new int[]{3, 2, 1};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
        a = new int[]{2, 2, 2, 3, 1};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
        a = new int[]{2, 2, 2, 3, 3, 3, 4, 100, 12, 12, 122, 34, 1};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
        a = new int[]{2, 2, 3, 1};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
        a = new int[]{1, 2};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
        a = new int[]{2, 2, 3, 1};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
        a = new int[]{1, 1, 1, 1};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
        a = new int[]{};
        System.out.println(Arrays.toString(a) + " -> " + thirdMax((a)));
    }

}
