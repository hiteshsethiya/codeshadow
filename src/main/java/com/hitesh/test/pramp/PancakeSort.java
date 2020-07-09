package com.hitesh.test.pramp;

import java.util.Arrays;

public class PancakeSort {

    /**
     * Given an array of integers arr:
     *
     * Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
     * Write a function pancakeSort(arr) that sorts and returns the input array.
     * You are allowed to use only the function flip you wrote in the first step in order to make changes in the array.
     *
     * Example:
     *
     * input:  arr = [1, 5, 4, 3, 2]
     *
     * output: [1, 2, 3, 4, 5] # to clarify, this is pancakeSort's output
     * Analyze the time and space complexities of your solution.
     *
     * Note: it’s called pancake sort because it resembles sorting pancakes on a plate with a spatula, where you can only use the spatula to flip some of the top pancakes in the plate. To read more about the problem, see the Pancake Sorting Wikipedia page.
     *
     * Constraints:
     *
     * [time limit] 5000ms
     *
     * [input] array.integer arr
     *
     * [input] integer k
     *
     * 0 ≤ k
     * [output] array.integer
     */

    static void flip(int[] arr, int k) {
        for(int i = 0; i <= (k/2); ++i) {
            int t = arr[i];
            arr[i] = arr[k - i];
            arr[k - i] = t;
        }
    }

    static int maxIdx(int[] a, int k) {
        int maxI = 0, max = a[0];
        for(int i = 1; i < k; ++i) {
            if(a[i] > max) {
                maxI = i;
                max = a[i];
            }
        }
        return maxI;
    }

    static int[] pancakeSort(int[] arr) {
        // your code goes here
        for(int i = arr.length - 1; i > 0; --i) {
            int maxI = maxIdx(arr, i);
            System.out.println("i : " + i + " : maxI : " + maxI + " : " + Arrays.toString(arr));
            flip(arr, maxI);
            System.out.println("i : " + i + " : maxI : " + maxI + " : " + Arrays.toString(arr));
            flip(arr, i);
            System.out.println("i : " + i + " : maxI : " + maxI + " : " + Arrays.toString(arr));
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,4,1};
        System.out.println(Arrays.toString(pancakeSort(a)));
    }

}
