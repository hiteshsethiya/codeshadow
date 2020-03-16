package com.hitesh.test.g4gcourse.array;

/**
 * Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 *
 * Input:
 * The first line contains an integer T, depicting total number of test cases.  Then T test case follows. First line of each test case contains an integer N denoting the size of the array. Next line contains N space separated integeres denoting the elements of the array.
 *
 * Output:
 * Print the maximum difference of the indexes i and j in a separate line.
 *
 * User Task:
 * The task is to complete the function maxIndexDiff() which finds and returns maximum index difference. Printing the output will be handled by driver code.
 *
 * Constraints:
 * 1 ≤ T ≤ 1000
 * 1 ≤ N ≤ 107
 * 0 ≤ A[i] ≤ 1018
 *
 * Example:
 * Input:
 * 2
 * 2
 * 1 10
 * 9
 * 34 8 10 3 2 80 30 33 1
 *
 * Output:
 * 1
 * 6
 *
 * Explanation:
 * Testcase 1:  In the given array A[1] < A[7] satisfying the required condition(A[i] <= A[j]) thus giving the maximum difference of j - i which is 6(7-1).
 */
public class MaximumIndex {

    public static int maxIndexDiffBf(int arr[], int n) {
        int maxDiff = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = n - 1; j > i; --j) {
                if(arr[j] >= arr[i]) {
                    maxDiff = Math.max(maxDiff, j - i);
                }
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] a = new int[] {34, 8 ,10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiffBf(a, a.length));
        a = new int[] {1, 1, 1, 1, 1};
        System.out.println(maxIndexDiffBf(a, a.length));
    }

}
