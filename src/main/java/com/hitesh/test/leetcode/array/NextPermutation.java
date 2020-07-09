package com.hitesh.test.leetcode.array;

import java.util.Arrays;

public class NextPermutation {

    /*
     * Implement next permutation, which rearranges numbers into the
     * lexicographically next greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the
     * lowest possible order (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and
     * its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0 && nums[i] >= nums[i + 1]; --i);
        if (i >= 0) {
            int j = nums.length - 1;
            for (; nums[j] <= nums[i]; --j) ;
            swap(nums, i, j);
        }
        int j = nums.length - 1;
        for(i = i + 1; i < j; ++i, --j)
            swap(nums, i, j);
    }

    public void swap(int[] a, int i, int j) {
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    public static void execute(int[] nums, int[] exp) {
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.equals(nums, exp));
    }

    public static void main(String[] args) {
        execute(new int[]{1}, new int[]{1});
        execute(new int[]{1, 2}, new int[]{2, 1});
        execute(new int[]{100, 200, 99}, new int[]{200, 99, 100});
        execute(new int[]{1, 2, 3}, new int[]{1, 3, 2});
        execute(new int[]{1, 1, 5}, new int[]{1, 5, 1});
        execute(new int[]{5, 1, 1}, new int[]{1, 1, 5});
        execute(new int[]{3, 2, 1}, new int[]{1, 2, 3});
    }
}
