package com.hitesh.test.leetcode.array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    /**
     * Given an integer array, you need to find one continuous subarray that
     * if you only sort this subarray in ascending order,
     * then the whole array will be sorted in ascending order, too.
     * <p>
     * You need to find the shortest such subarray and output its length.
     * <p>
     * Example 1:
     * Input: [2, 6, 4, 8, 10, 9, 15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     * <p>
     * Note:
     * Then length of the input array is in range [1, 10,000].
     * The input array may contain duplicates, so ascending order here means <=.
     * 9481202762
     */

    static public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, s = 0, e = -1;
        int l = 0, r = nums.length - 1;
        while (r >= 0) {
            if (nums[l] >= max)
                max = nums[l];
            else e = l;
            if (nums[r] <= min)
                min = nums[r];
            else
                s = r;
            l++;
            r--;
        }

        return e - s + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 3, 2, 4};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{2, 3, 3, 2, 4, 3};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{2, 6, 4, 8, 15, 9, 10};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{1, 2, 13, 14, 15, 3};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{1, 2, 3, 4, 5, 0};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{1, 2};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{2, 1};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
        a = new int[]{2, 1, 3};
        System.out.println(Arrays.toString(a) + " -> " + findUnsortedSubarray(a));
    }

    static public class BruteForceSolution {

        /**
         * Approach 1: Brute Force
         * Algorithm
         * <p>
         * In the brute force approach, we consider every possible subarray that can be formed
         * from the given array numsnums. For every subarray nums[i:j]nums[i:j] considered,
         * we need to check whether this is the smallest unsorted subarray or not.
         * Thus, for every such subarray considered, we find out the maximum and minimum values
         * lying in that subarray given by max and min respectively.
         * <p>
         * If the subarrays nums[0:i-1]nums[0:i−1] and nums[j:n-1]nums[j:n−1] are correctly sorted,
         * then only nums[i:j]nums[i:j] could be the required subrray.
         * Further, the elements in nums[0:i-1]nums[0:i−1] all need to be lesser than the min
         * for satisfying the required condition.
         * Similarly, all the elements in nums[j:n-1]nums[j:n−1] need to be larger than max.
         * We check for these conditions for every possible ii and jj selected.
         * <p>
         * Further, we also need to check if nums[0:i-1]nums[0:i−1] and nums[j:n-1]nums[j:n−1] are sorted correctly.
         * If all the above conditions are satisfied, we determine the length of the unsorted subarray as j-ij−i.
         * We do the same process for every subarray chosen and determine the length of the smallest
         * unsorted subarray found.
         */

        public int findUnsortedSubarray(int[] nums) {
            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j <= nums.length; j++) {
                    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, nums[k]);
                        max = Math.max(max, nums[k]);
                    }
                    if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
                        continue;
                    int k = 0;
                    while (k < i && prev <= nums[k]) {
                        prev = nums[k];
                        k++;
                    }
                    if (k != i)
                        continue;
                    k = j;
                    while (k < nums.length && prev <= nums[k]) {
                        prev = nums[k];
                        k++;
                    }
                    if (k == nums.length) {
                        res = Math.min(res, j - i);

                    }
                }
            }
            return res;
        }
    }

}
