package com.hitesh.test.leetcode.array;

public class MedianofTwoSortedArrays {

    /*
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     */

    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }
        int l = 0, r = a.length, n = a.length + b.length, x = a.length, y = b.length;
        int form = (x + y + 1) / 2;
        while (l <= r) {
            int partitionX = l + (r - l) / 2;
            int partitionY = form - partitionX;
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : a[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : a[partitionX];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : b[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : b[partitionY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if (n % 2 == 0) return ((Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0);
                return Math.max(maxLeftX, maxLeftY);
            } else if (maxLeftX > minRightY) {
                r = partitionX - 1;
            } else {
                l = partitionX + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(a, b));
        b = new int[]{1, 3};
        a = new int[]{2};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(a, b));
        b = new int[]{3, 4};
        a = new int[]{1, 2};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(a, b));
    }

}
