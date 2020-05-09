package com.hitesh.test.leetcode.matrix;

public class RotateImage {

    /**
     * You are given an n x n 2D matrix representing an image.
     *
     * Rotate the image by 90 degrees (clockwise).
     *
     * Note:
     *
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     *
     * Example 1:
     *
     * Given input matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * rotate the input matrix in-place such that it becomes:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     * Example 2:
     *
     * Given input matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * rotate the input matrix in-place such that it becomes:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     */

    public static int swapAndReturn(int[][] a, int i, int j, int var) {
        int temp = a[i][j];
        a[i][j] = var;
        return temp;
    }

    static public void rotate(int[][] a) {
        int m = a.length - 1;
        int n = a[0].length - 1;
        if (m != n) return; // Has to be a square matrix
        for (int i = 0; i < a.length / 2; ++i) {
            for (int j = i; j < n - i; ++j) {
                int temp = a[i][j];
                temp = swapAndReturn(a, j, (n - i), temp);
                temp = swapAndReturn(a, (n - i), (n - j), temp);
                temp = swapAndReturn(a, (n - j), i, temp);
                swapAndReturn(a, i, j, temp);
            }
        }
    }
}
