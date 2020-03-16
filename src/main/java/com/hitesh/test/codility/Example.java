package com.hitesh.test.codility;

import java.util.Map;
import java.util.TreeMap;

public class Example {

    /**
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     *
     * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
     *
     * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     *
     * Given A = [1, 2, 3], the function should return 4.
     *
     * Given A = [−1, −3], the function should return 1.
     *
     * Write an efficient algorithm for the following assumptions:
     *
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [−1,000,000..1,000,000].
     */

    static public int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null || A.length == 0) return 1;
        boolean[] c = new boolean[1000001];
        int max = 0;
        for(int i = 0; i < A.length; ++i) {
            if(A[i] > 0) c[A[i]] = true;
            max = Math.max(max, A[i]);
        }
        for(int i = 1; i <= max; ++i) {
            if(!c[i]) return i;
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 3, 6, 4, 1, 2};
        System.out.println(solution(a));
        a = new int[] {1, 2, 3};
        System.out.println(solution(a));
        a = new int[] {-1, -2, -3};
        System.out.println(solution(a));
        a = new int[] {-1, -2, -3, 1, 2, 3};
        System.out.println(solution(a));
        a = new int[] {0, 0, 0, 0, 1};
        System.out.println(solution(a));
    }

}
