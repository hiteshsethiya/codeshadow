package com.hitesh.test.leetcode.matrix;

public class MinimumPathSum {
    /*
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * Example:
     *
     * Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     */



    static public int minPathSumBF(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        return sumBruteForce(grid, 0, 0, 0);
    }

    static public int minPathSum(int[][] grid) {
        return sumDp(grid);
    }

    static public int sumDp(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        final int m = grid.length, n = grid[0].length;
        for(int i = 1; i < m; ++i) {
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }
        for(int i = 1; i < n; ++i) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j],
                        grid[i][j] + grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * Brute Force
     * Compute all paths from 0,0 till m - 1, n - 1 where m = rows, n = columns
     * @param grid input
     * @param i - rowIdx
     * @param j - colIdx
     * @param sum - sum until now
     * @return - min sum
     */
    static public int sumBruteForce(int[][] grid, int i, int j, int sum) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return sum + grid[i][j];
        return Math.min(sumBruteForce(grid, i, j + 1, sum + grid[i][j]),
                sumBruteForce(grid, i + 1, j, sum + grid[i][j]));
    }

    public static void execute(int[][] grid, int exp) {
        long startTime = System.currentTimeMillis();
        int c = minPathSum(grid);
        System.out.println(c);
        System.out.println(c == exp);
        System.out.println(((System.currentTimeMillis() - startTime) / 1000) + "s");
    }

    public static void main(String[] args) {
        int g[][] = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        execute(g, 7);
        g = new int[][]{
                {3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2},
                {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7},
                {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9},
                {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3},
                {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8},
                {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3},
                {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5},
                {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0},
                {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}
        };
        execute(g, 83);
    }


}
