package com.hitesh.test.leetcode.graph;

import java.util.*;

public class SurroundedRegions {

    /*
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * Example:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * Explanation:
     *
     * Surrounded regions shouldn’t be on the border, which means that any 'O' on the
     * border of the board are not flipped to 'X'. Any 'O' that is not on the border
     * and it is not connected to an 'O' on the border will be flipped to 'X'.
     * Two cells are connected if they are adjacent cells connected horizontally or vertically.
     */

    static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, // right
            {1, 0}, // down
            {0, -1},// left
            {-1, 0} // up
    };

    public static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isValid(int i, int j, int m, int n) {
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }

    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) return;
        int m = board.length, n = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            if(board[i][0] == 'O') {
                board[i][0] = '*';
                q.add(new Pair(i, 0));
            }
            if(board[i][n - 1] == 'O') {
                board[i][n - 1] = '*';
                q.add(new Pair(i, n - 1));
            }
        }
        for (int j = 0; j < n; ++j) {
            if(board[0][j] == 'O') {
                board[0][j] = '*';
                q.add(new Pair(0, j));
            }
            if(board[m - 1][j] == 'O') {
                board[m - 1][j] = '*';
                q.add(new Pair(m - 1, j));
            }
        }

        while(!q.isEmpty()) {
            Pair iPair = q.poll();
            for(int[] iDir : DIRECTIONS) {
                int r = iPair.r + iDir[0], c = iPair.c + iDir[1];
                if(isValid(r, c, m, n) && board[r][c] == 'O') {
                    Pair neighbor = new Pair(r, c);
                    q.add(neighbor);
                    board[r][c] = '*';
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(board[i][j] == '*') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        new SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(board));
        board = new char[][]{
                {'X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','X','X'},
                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','X'},
                {'O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
                {'O','O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','X','O','O','X'},
                {'X','O','O','O','X','O','O','O','O','O','X','O','X','O','X','O','X','O','X','O'},
                {'O','O','O','O','X','O','O','X','O','O','O','O','O','X','O','O','X','O','O','O'},
                {'X','O','O','O','X','X','X','O','X','O','O','O','O','X','X','O','X','O','O','O'},
                {'O','O','O','O','O','X','X','X','X','O','O','O','O','X','O','O','X','O','O','O'},
                {'X','O','O','O','O','X','O','O','O','O','O','O','X','X','O','O','X','O','O','X'},
                {'O','O','O','O','O','O','O','O','O','O','X','O','O','X','O','O','O','X','O','X'},
                {'O','O','O','O','X','O','X','O','O','X','X','O','O','O','O','O','X','O','O','O'},
                {'X','X','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'O','X','O','X','O','O','O','X','O','X','O','O','O','X','O','X','O','X','O','O'},
                {'O','O','X','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','X','O'},
                {'X','X','O','O','O','O','O','O','O','O','X','O','X','X','O','O','O','X','O','O'},
                {'O','O','X','O','O','O','O','O','O','O','X','O','O','X','O','X','O','X','O','O'},
                {'O','O','O','X','O','O','O','O','O','X','X','X','O','O','X','O','O','O','X','O'},
                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
                {'X','O','O','O','O','X','O','O','O','X','X','O','O','X','O','X','O','X','O','O'}};
        new SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(board));
    }

}
