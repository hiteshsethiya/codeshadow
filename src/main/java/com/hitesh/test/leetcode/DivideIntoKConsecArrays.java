package com.hitesh.test.leetcode;

import java.util.*;

public class DivideIntoKConsecArrays {

    public static boolean isPossibleDivide(int[] nums, int k) {
        if(k == 0 || nums.length == 0) return true;
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }
        while (!treeMap.isEmpty()) {
            for(int i = treeMap.firstKey(), j = 0; j < k; ++j, ++i) {
                if(!treeMap.containsKey(i)) {
                    return false;
                }
                int count = treeMap.ceilingEntry(i).getValue() - 1;
                if(count >= 1) {
                    treeMap.put(i, count);
                } else {
                    treeMap.remove(i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{15, 16, 17, 18, 19, 16, 17, 18, 19, 20, 6, 7, 8, 9, 10, 3, 4, 5, 6, 20};
        System.out.println(isPossibleDivide(a, 5));
        a = new int[]{3, 3, 2, 2, 1, 1};
        System.out.println(isPossibleDivide(a, 3));
        a = new int[]{1, 2, 3, 3, 4, 4, 5, 6};
        System.out.println(isPossibleDivide(a, 4));
        a = new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        System.out.println(isPossibleDivide(a, 3));
        a = new int[]{1, 2, 3, 4};
        System.out.println(isPossibleDivide(a, 3));
        a = new int[]{1, 2, 3, 4};
        System.out.println(isPossibleDivide(a, 2));
        a = new int[]{100, 200, 300, 400};
        System.out.println(isPossibleDivide(a, 2));
    }

}
