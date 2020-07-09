package com.hitesh.test.leetcode.binary;

public class MaxConsecutiveOnesIII {

    /**
     * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
     * <p>
     * Return the length of the longest (contiguous) subarray that contains only 1s.
     * <p>
     * Example 1:
     * <p>
     * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * Output: 6
     * Explanation:
     * [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
     * Example 2:
     * <p>
     * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * Output: 10
     * Explanation:
     * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
     * <p>
     * Note:
     * <p>
     * 1 <= A.length <= 20000
     * 0 <= K <= A.length
     * A[i] is 0 or 1
     */

    public int longestOnes(int[] a, int k) {
        int max = 0;
        for (int i = 0, j = 0; j < a.length; ++j) {
            if (a[j] == 0) {
                if (k > 0)
                    --k;
                else
                    while (a[i++] == 1) ;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void execute(int[] nums, int k, int exp) {
        int o = new MaxConsecutiveOnesIII().longestOnes(nums, k);
        System.out.println(o);
        System.out.println(o == exp);
    }

    public static void main(String[] arg) {
        execute(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0}, 2, 6);
        execute(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6);
        execute(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10);
        execute(new int[]{1, 0, 1, 1, 0}, 1, 4);
        execute(new int[]{1, 0, 1, 1, 0}, 2, 5);
        execute(new int[]{1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1}, 3, 11);
        execute(new int[]{0, 0, 0, 0}, 4, 4);
        execute(new int[]{0, 0}, 1, 1);
        execute(new int[]{0}, 1, 1);
        execute(new int[]{1}, 1, 1);
        execute(new int[]{1, 0}, 1, 2);
        execute(new int[]{0, 1, 0}, 2, 3);
        execute(new int[]{1, 1, 1, 1, 1}, 5, 5);
    }

}
