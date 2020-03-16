package com.hitesh.test.g4gcourse.array.binarysearch;

public class FindPeakInUnsortedArray {

    static int findPeak(int[] a) {
        for(int l = 0, h = a.length - 1; l <= h; ) {
            int m = l + (h - l) / 2;
            if(a[m - 1] <= a[m] && a[m + 1] <= a[m]) {
                return m;
            } else if(a[m - 1] > a[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeak(new int[] {11, 20, 400, 50, 60, 71, 8}));
        System.out.println(findPeak(new int[] {11, 20, 65, 60, 400, 8}));
    }
}
