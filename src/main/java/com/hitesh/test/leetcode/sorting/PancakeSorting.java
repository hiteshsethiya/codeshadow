package com.hitesh.test.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {

    /**
     * Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length,
     * then reverse the order of the first k elements of A.
     * We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.
     *
     * Return the k-values corresponding to a sequence of pancake flips that sort A.
     * Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

     * Example 1:
     *
     * Input: [3,2,4,1]
     * Output: [4,2,4,3]
     * Explanation:
     * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
     * Starting state: A = [3, 2, 4, 1]
     * After 1st flip (k=4): A = [1, 4, 2, 3]
     * After 2nd flip (k=2): A = [4, 1, 2, 3]
     * After 3rd flip (k=4): A = [3, 2, 1, 4]
     * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
     *
     * Example 2:
     *
     * Input: [1,2,3]
     * Output: []
     * Explanation: The input is already sorted, so there is no need to flip anything.
     * Note that other answers, such as [3, 3], would also be accepted.
     *
     * Note:
     *
     * 1 <= A.length <= 100
     * A[i] is a permutation of [1, 2, ..., A.length]
     */

    static void flip(int[] arr, int k) {
        for(int i = 0; i <= (k/2); ++i) {
            int t = arr[i];
            arr[i] = arr[k - i];
            arr[k - i] = t;
        }
    }

    static int findMaxI(int[] a, int k) {
        int max = a[0], maxI = 0;
        for(int i = 0; i < k; ++i) {
            if(max < a[i]) {
                max = a[i];
                maxI = i;
            }
        }
        return maxI;
    }

    static public List<Integer> pancakeSort(int[] A) {
        List<Integer> flips = new ArrayList<>();
        for(int i = A.length - 1; i > 0; --i) {
            int maxI = findMaxI(A, i + 1);
            if(maxI != i) {
                flip(A, maxI);
                flips.add(maxI + 1);
                flip(A, i);
                flips.add(i + 1);
            }
        }
//        System.out.println(Arrays.toString(A));
        return flips;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,4,1};
        System.out.println(pancakeSort(a));
        System.out.println();
        a = new int[]{1, 2, 3};
        System.out.println(pancakeSort(a));
        System.out.println();
        a = new int[]{3, 2, 1};
        System.out.println(pancakeSort(a));
        System.out.println();
        a = new int[]{1, 3};
        System.out.println(pancakeSort(a));
        System.out.println();
        a = new int[]{1};
        System.out.println(pancakeSort(a));
        System.out.println();
        a = new int[]{};
        System.out.println(pancakeSort(a));
    }

}
