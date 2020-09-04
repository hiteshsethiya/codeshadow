package com.hitesh.test.leetcode.matrix;

import java.util.Arrays;

public class GameofLife {

    /**
     * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
     * devised by the British mathematician John Horton Conway in 1970."
     * <p>
     * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
     * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using
     * the following four rules (taken from the above Wikipedia article):
     * <p>
     * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     * Any live cell with two or three live neighbors lives on to the next generation.
     * Any live cell with more than three live neighbors dies, as if by over-population..
     * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * Write a function to compute the next state (after one update) of the board given its current state.
     * The next state is created by applying the above rules simultaneously to every cell in the current state,
     * where births and deaths occur simultaneously.
     * <p>
     * Example:
     * <p>
     * Input:
     * [
     * [0,1,0],
     * [0,0,1],
     * [1,1,1],
     * [0,0,0]
     * ]
     * Output:
     * [
     * [0,0,0],
     * [1,0,1],
     * [0,1,1],
     * [0,1,0]
     * ]
     * Follow up:
     * <p>
     * 1.   Could you solve it in-place? Remember that the board needs to be updated at the same time:
     * You cannot update some cells first and then use their updated values to update other cells.
     * 2.   In this question, we represent the board using a 2D array. In principle, the board is infinite,
     * which would cause problems when the active area encroaches the border of the array.
     * How would you address these problems?
     */

    static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, // right
            {1, 0}, // down
            {0, -1},// left
            {-1, 0}, // up
            {-1, -1}, // Diagonal LEFT TOP
            {1, -1}, // Diagonal LEFT BOTTOM
            {1, 1}, // Diagonal RIGHT BOTTOM
            {-1, 1}, // Diagonal RIGHT TOP
    };

    /**
     * states
     * 1. i, j && 1 with one neighbour alive -> 2 = 0
     * 2. i, j && 1 with 2 or 3 neighbour alive -> 3 = 1
     * 3. i, j && 0 with 3 neighbours alive -> -2
     * 4. i, j && 1 with > 3 neighbour alive -> 4
     */

    static int count(int[][] board, int i, int j) {

        if (i >= board.length
                || i < 0
                || j < 0
                || j >= board[0].length
                || board[i][j] % 10 == 0) {
            return 0;
        }
        return 1;
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int count = 0;
                for (int[] iDir : DIRECTIONS) {
                    count += count(board, i + iDir[0], j + iDir[1]);
                }
                board[i][j] = (count * 10 + board[i][j]);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean isLive = board[i][j] % 10 == 1;
                int neighborCount = board[i][j] / 10;
                if (isLive) {
                    if (neighborCount < 2) {
                        board[i][j] = 1;
                    }
                    if (neighborCount == 2 || neighborCount == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                } else if (neighborCount == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] b = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(b);
        System.out.println(Arrays.deepToString(b));
    }

}
