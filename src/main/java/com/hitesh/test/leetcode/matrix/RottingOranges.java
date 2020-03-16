package com.hitesh.test.leetcode.matrix;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RottingOranges {

    /*
     * In a given grid, each cell can have one of three values:
     *
     * the value 0 representing an empty cell;
     * the value 1 representing a fresh orange;
     * the value 2 representing a rotten orange.
     * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

     * Example 1:
     * Input: [[2,1,1],[1,1,0],[0,1,1]]
     * Output: 4
     *
     * Example 2:
     * Input: [[2,1,1],[0,1,1],[1,0,1]]
     * Output: -1
     * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
     *
     * Example 3:
     * Input: [[0,2]]
     * Output: 0
     * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
     *
     *
     * Note:
     *
     * 1 <= grid.length <= 10
     * 1 <= grid[0].length <= 10
     * grid[i][j] is only 0, 1, or 2.
     */

    /*
     * Breadth First Search is the soln.
     */

    static class Solution {
        static int[] dr = new int[]{-1, 0, 1, 0};
        static int[] dc = new int[]{0, -1, 0, 1};

        static public int orangesRotting(int[][] grid) {
            int R = grid.length, C = grid[0].length;

            // queue : all starting cells with rotten oranges
            Queue<Integer> queue = new ArrayDeque<>();
            Map<Integer, Integer> depth = new HashMap<>();
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c)
                    if (grid[r][c] == 2) {
                        int code = r * C + c;
                        queue.add(code);
                        depth.put(code, 0);
                    }

            int ans = 0;
            while (!queue.isEmpty()) {
                int code = queue.remove();
                int r = code / C, c = code % C;
                for (int k = 0; k < 4; ++k) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        int ncode = nr * C + nc;
                        queue.add(ncode);
                        depth.put(ncode, depth.get(code) + 1);
                        ans = depth.get(ncode);
                    }
                }
            }

            for (int[] row : grid)
                for (int v : row)
                    if (v == 1)
                        return -1;
            return ans;
        }
    }


    public static int getCode(int i, int j, int mod) {
        return i * mod + j;
    }

    static public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int mins = 0;
        int[] dr = {-1, 1, 0, 0}; // {-1, 0, 1, 0}
        int[] dc = {0, 0, 1, -1}; // {0, -1, 0, 1}
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 2) {
                    int c = getCode(i, j, grid[0].length);
                    q.add(c);
                    depth.put(c, 0);
                }

        while (!q.isEmpty()) {
            int code = q.remove();
            int i = code / grid[0].length;
            int j = code % grid[0].length;
            for (int k = 0; k < dr.length; ++k) {
                int r = i + dr[k];
                int c = j + dc[k];
                if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 1) {
                    grid[r][c] = 2;
                    int nCode = getCode(r, c, grid[0].length);
                    q.add(nCode);
                    depth.put(nCode, depth.get(code) + 1);
                    mins = depth.get(nCode);
                }
            }
        }

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (ints[j] == 1) return -1;
            }
        }
        return mins;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(a));
//        System.out.println(Solution.orangesRotting(a));
        a = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(orangesRotting(a));
        a = new int[][]{
                {0, 2}
        };
        System.out.println(orangesRotting(a));
        a = new int[][]{};
        System.out.println(orangesRotting(a));
        a = new int[][]{
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {2, 0, 1, 1},
                {1, 0, 0, 2},
                {0, 1, 0, 2}
        };
        System.out.println(orangesRotting(a));
    }

}
