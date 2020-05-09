package com.hitesh.test.leetcode.matrix;

import java.util.LinkedList;

public class MaximalSquare {

    /*
     * Given a 2D binary matrix filled with 0's and 1's,
     * find the largest square containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * Output: 4
     */

    static public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        if (m == 1 && n == 1) {
            return matrix[0][0] - '0';
        }
        int[][] s = new int[m][n];
        int square = 0;
        for (int i = 0; i < m; ++i) {
            s[i][0] = matrix[i][0] - '0';
            square = Math.max(s[i][0], square);
        }
        for (int i = 1; i < n; ++i) {
            s[0][i] = matrix[0][i] - '0';
            square = Math.max(s[0][i], square);
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    s[i][j] = Math.min(Math.min(s[i - 1][j], s[i - 1][j - 1]), s[i][j - 1]) + 1;
                } else {
                    s[i][j] = 0;
                }
                square = Math.max(s[i][j], square);
            }
        }

        return square;
    }

    static public void execute(char[][] inp, int exp) {
        int ans = maximalSquare(inp);
        MatrixUtil.soutMatrix(inp);
        System.out.println(ans);
        System.out.println(ans == exp);
    }

    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'1', '0', '1', '0', '0',},
                {'1', '0', '1', '1', '1',},
                {'1', '1', '1', '1', '1',},
                {'1', '0', '0', '1', '0'}
        };
        execute(a, 2);
        a = new char[][]{
                {'1'}
        };
        execute(a, 1);
        a = new char[][]{
                {'0'}
        };
        execute(a, 0);
        a = new char[][]{
                {'1', '1', '1', '1', '1',},
        };
        execute(a, 1);
        a = new char[][]{
                {'1'},
                {'1'},
                {'1'},
                {'1'}
        };
        execute(a, 1);
    }

}
