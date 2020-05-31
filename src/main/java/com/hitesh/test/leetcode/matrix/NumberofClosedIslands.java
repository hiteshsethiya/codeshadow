package com.hitesh.test.leetcode.matrix;

public class NumberofClosedIslands {

    /**
     * Given a 2D grid consists of 0s (land) and 1s (water).
     * An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally
     * (all left, top, right, bottom) surrounded by 1s.
     * <p>
     * Return the number of closed islands.
     * <p>
     * Example 1:
     * <p>
     * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
     * Output: 2
     * Explanation:
     * Islands in gray are closed because they are completely surrounded by water (group of 1s).
     * <p>
     * Example 2:
     * <p>
     * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
     * Output: 1
     * <p>
     * Example 3:
     * <p>
     * Input: grid = [[1,1,1,1,1,1,1],
     * [1,0,0,0,0,0,1],
     * [1,0,1,1,1,0,1],
     * [1,0,1,0,1,0,1],
     * [1,0,1,1,1,0,1],
     * [1,0,0,0,0,0,1],
     * [1,1,1,1,1,1,1]]
     * Output: 2
     * <p>
     * Constraints:
     * <p>
     * 1 <= grid.length, grid[0].length <= 100
     * 0 <= grid[i][j] <=1
     */

    static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, // right
            {1, 0}, // down
            {0, -1},// left
            {-1, 0} // up
    };

    static public boolean closedBfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length
                || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 1) return true;
        visited[i][j] = true;
        if (grid[i][j] == 0 && (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1)) return false;
        boolean closed = true;
        for (int[] iDir : DIRECTIONS) {
            closed &= closedBfs(grid, visited, i + iDir[0], j + iDir[1]);
        }
        return closed;
    }

    static public int closedIsland(int[][] grid) {
        if (grid == null || grid.length <= 2 || grid[0].length <= 2) return 0;
        int m = grid.length, n = grid[0].length;
        int closedIslands = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (grid[i][j] == 0 && !visited[i][j] && closedBfs(grid, visited, i, j)) {
                    closedIslands++;
                }
            }
        }
        return closedIslands;
    }

    public static void execute(int[][] grid, int exp) {
        int c = closedIsland(grid);
        System.out.println(c);
        System.out.println(c == exp);
    }

    public static void main(String[] args) {
        int g[][] = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        execute(g, 1);
        g = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 0, 1}
        };
        execute(g, 0);
        g = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        execute(g, 1);
        g = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        execute(g, 2);
        g = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };
        execute(g, 1);
    }
}
