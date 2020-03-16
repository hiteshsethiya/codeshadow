package com.hitesh.test.leetcode.search;

public class FindMinInRotatedSortedArray {

    public static int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int min = nums[0], item = nums[0];
        for (int l = 0, r = nums.length - 1; l <= r; ) {
            int m = l + (r - l) / 2;
            min = Math.min(min, nums[m]);
            if (item <= nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7, -1,0,1,2}));
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{3,3, 3, 3}));
    }

}
