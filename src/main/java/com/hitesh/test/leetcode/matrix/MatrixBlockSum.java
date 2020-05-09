package com.hitesh.test.leetcode.matrix;

import java.util.Arrays;

public class MatrixBlockSum {

    /*
     * Given a m * n matrix mat and an integer k, return a matrix answer
     * where each answer[i][j] is the sum of all elements mat[r][c]
     * for i - k <= r <= i + k, j - k <= c <= j + k, and (r, c) is a valid position in the matrix.
     *
     *
     * Example 1:
     *
     * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
     * Output: [[12,21,16],[27,45,33],[24,39,28]]
     * Example 2:
     *
     * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
     * Output: [[45,45,45],[45,45,45],[45,45,45]]
     *
     *
     * Constraints:
     *
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n, k <= 100
     * 1 <= mat[i][j] <= 100
     */

    /**
     * Uses the inclusion-exclusion principle.
     * Memoize the block sums of sub matrices.
     * blockSum((i,j), (i + k, j + k)) = dp[i+k][[j+k] - dp[i-k-1][[j-k-1]
     * sumInMatrix(i,j) = sum(i-1,j) + sum(i,j-1) - sum(i-1,j-1)
     *
     * @param mat - input
     * @param k   - input
     * @return - block sum
     */
    static public int[][] matrixBlockSum(int[][] mat, int k) {
        if (mat == null) return null;
        int m = mat.length;
        int n = mat[0].length;
        // initialise with block sums
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j < dp[0].length; ++j) {
                dp[i][j] = dp[i - 1][j] //top
                        + dp[i][j - 1] //left
                        + mat[i - 1][j - 1]  // the value in the input
                        - dp[i - 1][j - 1]; // previous block matrix's sum
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k) + 1;
                int c1 = Math.max(0, j - k) + 1;
                int r2 = Math.min(m, i + k + 1);
                int c2 = Math.min(n, j + k + 1);
                mat[i][j] = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
            }
        }
        return mat;
    }

    public static void execute(int[][] a, int k, int[][] exp) {
        int[][] ans = matrixBlockSum(a, k);
        MatrixUtil.soutMatrix(ans);
        System.out.println(Arrays.deepEquals(ans, exp));
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] exp = new int[][]{
                {12, 21, 16},
                {27, 45, 33},
                {24, 39, 28}
        };
        int k = 1;
        execute(a, k, exp);
    }

}
