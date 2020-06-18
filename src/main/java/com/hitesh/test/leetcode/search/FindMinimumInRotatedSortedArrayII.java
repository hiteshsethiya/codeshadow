package com.hitesh.test.leetcode.search;

public class FindMinimumInRotatedSortedArrayII {

    public int findMinRecur(int[] nums, int l, int r) {
        if(l > r) return Integer.MAX_VALUE;
        int m = l + (r - l) / 2;
        int left = nums[m - 1 < 0 ? nums.length - 1 : m - 1];
        int right = nums[(m + 1) % nums.length];
        if(left > nums[m]) {
            return nums[m];
        }
        if(nums[m] > right) {
            return right;
        }
        int leftMin = findMinRecur(nums, l, m - 1);
        int rightMin = findMinRecur(nums, m + 1, r);

        return Math.min(nums[m], Math.min(Math.min(left, Math.min(leftMin, rightMin)), right));
    }

    public int findMin(int[] nums) {
        return findMinRecur(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{4,5,6,7, -1,0,1,2}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{3,3, 3, 3}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{1,2,3,4,5}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{6,1,2,3,4,5}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{2,2,2,2,2,0}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{0,2,2,2,2}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{2,2,0,2,2}));
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{2,2,2,0,1}));
    }

}
