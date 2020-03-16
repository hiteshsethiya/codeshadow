package com.hitesh.test.g4gcourse.array.binarysearch;

import java.util.ArrayList;

public class BinarySearch {

    static int search(int[] a, int x) {
        for(int l = 0, h = a.length - 1; l <= h; ) {
            int m = l + (h - l) / 2;
            if(x == a[m]) {
                return m;
            } else if(a[m] > x) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    static int searchInDesc(int[] a, int x) {
        for(int l = 0, h = a.length - 1; l <= h; ) {
            int m = l + (h - l) / 2;
            if(x == a[m]) {
                return m;
            } else if(a[m] < x) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    static int rightMostOccurrenceInDesc(int[] arr, int x) {
        int ans = -1;
        for(int l = 0, h = arr.length - 1; l <= h; ) {
            int m = l + (h - l) / 2;
            if(arr[m] >= x) {
                if(arr[m] == x) ans = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return ans;
    }

    static int leftMostOccurrence(int[] arr, int x) {
        int ans = -1;
        for(int l = 0, h = arr.length - 1; l <= h; ) {
            int m = l + (h - l) / 2;
            if(arr[m] >= x) {
                if(arr[m] == x) ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(leftMostOccurrence(new int[] {1, 1, 2, 3, 4, 5} ,6));
        System.out.println(leftMostOccurrence(new int[] {1, 1, 2, 3, 4, 5} ,5));
        System.out.println(leftMostOccurrence(new int[] {1, 1, 2, 3, 4, 5} ,3));
        System.out.println(leftMostOccurrence(new int[] {1, 1, 2, 3, 4, 5} ,1));
        System.out.println(rightMostOccurrenceInDesc(new int[] {1, 1, 1, 1, 1, 1} ,1));
        System.out.println(rightMostOccurrenceInDesc(new int[] {1, 1, 0, 0, 0, 0} ,1));
        System.out.println(rightMostOccurrenceInDesc(new int[] {0, 0, 0, 0, 0, 0} ,1));
        System.out.println(rightMostOccurrenceInDesc(new int[] {5, 4, 3, 2, 1, 1, 1, 1} ,1));
        System.out.println(searchInDesc(new int[] {1, 1, 1, 1, 1, 1} ,1));
        System.out.println(search(new int[] {1, 2, 3, 4, 5} ,4));
        System.out.println(search(new int[] {1, 2, 3, 4, 5} ,14));
        System.out.println(search(new int[] {1, 2, 3, 4, 5} ,1));
        System.out.println(search(new int[] {1, 2, 30, 40, 50} ,20));
    }

}
