package com.hitesh.test.leetcode.matrix;

public class NumberofIslands {

    /*
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * Output: 1
     *
     * Example 2:
     *
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * Output: 3
     */

    /*
     * Does a BFS of the grid and marks all 1s as zeros to be sure that it has been visited.
     * Every time we encounter a '1', we do a BFS around it to mark all 1s as zeros and count this as 1 island.
     * @param grid - input
     * @return - no of islands
     */
    static public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0; // Empty grid check
        int islands = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == '1') {
                    islands++;
                    bfsIsland(grid, i, j);
                }
            }
        }
        return islands;
    }

    static public void bfsIsland(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        bfsIsland(grid, i - 1, j); // Up
        bfsIsland(grid, i + 1, j); // down
        bfsIsland(grid, i, j + 1); // right
        bfsIsland(grid, i, j - 1); // left
    }

    public static void execute(char[][] grid, int exp) {
        int c = numIslands(grid);
        System.out.println(c);
        System.out.println(c == exp);
    }

    public static void main(String[] args) {
        char g[][] = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        execute(g, 3);
        g = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        execute(g, 1);
    }

}
