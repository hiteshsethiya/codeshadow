package com.hitesh.test.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchInsert {
    public static int searchInsert(int[] a, int x) {
        int l = 0, h = a.length - 1;
        for(; l <= h; ) {
            int m = l + (h - l) / 2;
            if(x == a[m]) {
                return m;
            } else if(a[m] > x) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return h + 1;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 1, 2, 3, 4, 5} ,1));
        System.out.println(searchInsert(new int[] {1, 1, 3, 5, 6} ,4));
        System.out.println(searchInsert(new int[] {1, 1, 3, 5, 6} ,2));
        System.out.println(searchInsert(new int[] {1, 1, 3, 5, 6} ,8));
    }

    public List<Integer> sortArray(int[] nums) {
        Arrays.sort(nums);
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
    }
}
