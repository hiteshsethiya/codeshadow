package com.hitesh.test.leetcode.array;

public class SubarraySumsDivisiblebyK {

    /**
     * Given an array A of integers, return the number of
     * (contiguous, non-empty) subarrays that have a sum divisible by K.
     *
     * Example 1:
     *
     * Input: A = [4,5,0,-2,-3,1], K = 5
     * Output: 7
     * Explanation: There are 7 subarrays with a sum divisible by K = 5:
     * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
     *
     * Note:
     *
     * 1 <= A.length <= 30000
     * -10000 <= A[i] <= 10000
     * 2 <= K <= 10000
     */

    static public int subarraysDivByK(int[] a, int k) {
        int[] mod = new int[k];
        int cumSum = 0;
        for (int i = 0; i < a.length; ++i) {
            cumSum += a[i];
            mod[((cumSum % k) + k) % k]++;
        }
        int c = mod[0];
        for (int i = 0; i < mod.length; ++i) {
            if (mod[i] > 1)
                c += (mod[i] * (mod[i] - 1)) / 2;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = new int[] {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(a, k));
    }

}
