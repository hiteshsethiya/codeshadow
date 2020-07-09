package com.hitesh.test.leetcode.dp;

public class CountSquareSubmatricesWithAllOnes {

    /*
     * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
     *
     * Example 1:
     *
     * Input: matrix =
     * [
     *   [0,1,1,1],
     *   [1,1,1,1],
     *   [0,1,1,1]
     * ]
     * Output: 15
     * Explanation:
     * There are 10 squares of side 1.
     * There are 4 squares of side 2.
     * There is  1 square of side 3.
     * Total number of squares = 10 + 4 + 1 = 15.
     *
     * Example 2:
     *
     * Input: matrix =
     * [
     *   [1,0,1],
     *   [1,1,0],
     *   [1,1,0]
     * ]
     * Output: 7
     * Explanation:
     * There are 6 squares of side 1.
     * There is 1 square of side 2.
     * Total number of squares = 6 + 1 = 7.
     *
     *
     *
     * Constraints:
     *
     *     1 <= arr.length <= 300
     *     1 <= arr[0].length <= 300
     *     0 <= arr[i][j] <= 1
     */

    public int countSquares(int[][] matrix) {
        int count = 0, m = matrix.length;
        // if(m == 0) return 0;
        int n = matrix[0].length;
        // if(n == 0) return 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i > 0 && j > 0 && matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(
                            matrix[i - 1][j - 1],
                            Math.min(matrix[i - 1][j],
                                    matrix[i][j - 1])
                    ) + 1;
                }
                count += matrix[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("asdf");
    }
}
