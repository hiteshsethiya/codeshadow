package com.hitesh.test.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

    static void swap(List<Integer> a, int i, int j) {
        int t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] =  a[j];
        a[j] = t;
    }

    static List<Integer> getList(int[] a) {
        return Arrays.stream(a).boxed().collect(Collectors.toList());
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> o = new ArrayList<>();
        o.add(getList(nums));
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> a = getList(nums);
            for (int j = 0; j < nums.length; ++j) {
                if(j == i) continue;
                for (int k = j + 1; k < nums.length; ++k) {
                    if(k == i) continue;
                    swap(a, j, k);
                    o.add(new ArrayList<>(a));
                }
            }
        }
        return o;
    }

    public static void rPermute(List<List<Integer>> o, int[] nums, int l, int r) {
        if(l == r) {
            o.add(getList(nums));
            return;
        }
        for(int i = l; i <= r; ++i) {
            swap(nums, l, i);
            rPermute(o, nums, l + 1, r);
            swap(nums, l, i);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> o = new ArrayList<>();
        rPermute(o,new int[]{1, 2, 3}, 0, 2);
        o.forEach(System.out::println);
//        permute(new int[]{1, 2, 3}).forEach(
//                System.out::println
//        );
    }
}

/**
 * input array
 * fix one element, swap the others
 * 1, 2, 3
 * 1, 3, 2
 */
