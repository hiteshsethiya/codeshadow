package com.hitesh.test.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hacker Rank question for Dunzo.
 * ﻿1. Balancing Elements
 * Given an array of integers, we call an element a "balancing element" when its deletion from the array results in
 * the sum of the even-indexed elements being equal to the sum of the odd-indexed elements. When an element
 * is removed from the array, the remaining elements after it are shifted one position to the left to fill in the gap
 * that was created. Your task is to determine how many balancing elements a given array contains.
 * For example, consider the array [5, 5, 2, 5, 8]. When the first or second 5 is deleted, the array becomes [5, 2, 5, 8].
 * The sum of elements with even indices is 5+5=10, which is equal to the sum of elements with odd indices, since
 * 2+8=10. Since no other elements of the original array have that property, the answer is 2 because there are two
 * balancing elements (the first 5 and the second 5).
 * Function Description
 * Complete the function countBalancingEtements in the editor below. The function must return an integer
 * denoting the number of balancing elements in the input array.
 * countBalancingElements has the following parameter(s):
 * arr: an integer array of size n
 * Constraints
 * 1 <= n <= 2 * 10 ^ 5
 * 1 <= a[i] <= 10 ^ 9
 */
public class Balance {

    public static int c(int[] a, int n, int oSum, int eSum, int be) {
        if (oSum == eSum) return be;
        if (n == 0) return be;
        int iESum = eSum, iOSum = oSum;
        if ((n - 1) % 2 == 0) {
            eSum -= a[n];
            be += c(a, n - 1, iOSum, eSum, be + 1);
        } else {
            oSum -= a[n];
            be += c(a, n - 1, oSum, iESum, be + 1);
        }
        return be;
    }

    static class Tuple<K, V> {
        public K key;
        public V value;

        public Tuple(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public static Tuple<Integer, Integer> getEOSum(List<Integer> a) {
        int eSum = 0, oSum = 0;
        for (int i = 0; i < a.size(); ++i) {
            if (i % 2 == 0) {
                eSum += a.get(i);
            } else {
                oSum += a.get(i);
            }
        }
        return new Tuple<>(eSum, oSum);
    }

    public static void shift(List<Integer> a, List<Integer> d, int ignoreIdx) {
        for (int i = 0; i < a.size(); ++i) {
            if (i != ignoreIdx) {
                d.add(a.get(i));
            }
        }
    }

    public static int ca(List<Integer> a) {
        if (a == null || a.isEmpty()) return 0;
        int be = 0;
        for (int i = 0; i < a.size(); ++i) {
            List<Integer> d = new ArrayList<>();
            shift(a, d, i);
            Tuple<Integer, Integer> sums = getEOSum(d);
            if (sums.key.equals(sums.value)) be++;
        }
        return be;
    }


    /**
     * Using prefix arrays for odd and even sums.
     * Non-negative elements only.
     * @param a - input
     * @return - count of balancing elements
     */
    public static int cOptimised(List<Integer> a) {
        if (a == null || a.isEmpty() || a.size() < 2) return 0;
        int be = 0;
        int[] lSum = new int[a.size()];
        int[] rSum = new int[a.size()];
        lSum[0] = a.get(0);
        lSum[1] = a.get(1);
        rSum[rSum.length - 1] = a.get(a.size() - 1);
        rSum[rSum.length - 2] = a.get(a.size() - 2);
        int i = 2, j = a.size() - 3;
        for (; i < a.size() - 2; ++i, --j) {
            lSum[i] = lSum[i - 2] + a.get(i);
            rSum[j] = rSum[j + 2] + a.get(j);
        }
        lSum[i] = lSum[i - 2] + a.get(i);
        ++i;
        lSum[i] = lSum[i - 2] + a.get(i);

        rSum[j] = rSum[j + 2] + a.get(j);
        --j;
        rSum[j] = rSum[j + 2] + a.get(j);

        for (i = 0; i < a.size(); ++i) {
            int iESum, iOSum;
            if((i & 1) == 0) { // even
                iESum = lSum[i] - a.get(i) + (i + 1 < a.size() ? rSum[i + 1] : 0);
                iOSum = (i - 1 >= 0 ? lSum[i - 1] : 0) + (i + 2 < a.size() ? rSum[i + 2] : 0);
            } else {
                iOSum = lSum[i] - a.get(i) + (i + 1 < a.size() ? rSum[i + 1] : 0);
                iESum = (i - 1 >= 0 ? lSum[i - 1] : 0) + (i + 2 < a.size() ? rSum[i + 2] : 0);
            }
            if(iESum == iOSum) be++;
        }

        return be;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 5, 2, 5, 8};
        System.out.println(cOptimised(Arrays.stream(a).boxed().collect(Collectors.toList())));
        a = new int[]{4, 6, 2, 2};
        System.out.println(cOptimised(Arrays.stream(a).boxed().collect(Collectors.toList())));
    }

}






