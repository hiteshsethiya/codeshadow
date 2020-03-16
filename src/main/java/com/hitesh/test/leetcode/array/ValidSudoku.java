package com.hitesh.test.leetcode.array;

public class ValidSudoku {
    /**
     * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * <p>
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * <p>
     * A partially filled sudoku which is valid.
     * <p>
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     * Example 1:
     * <p>
     * Input:
     * [
     * ['5','3','.','.','7','.','.','.','.'],
     * ['6','.','.','1','9','5','.','.','.'],
     * ['.','9','8','.','.','.','.','6','.'],
     * ['8','.','.','.','6','.','.','.','3'],
     * ['4','.','.','8','.','3','.','.','1'],
     * ['7','.','.','.','2','.','.','.','6'],
     * ['.','6','.','.','.','.','2','8','.'],
     * ['.','.','.','4','1','9','.','.','5'],
     * ['.','.','.','.','8','.','.','7','9']
     * ]
     * Output: true
     * Example 2:
     * <p>
     * Input:
     * [
     * ['8','3','.','.','7','.','.','.','.'],
     * ['6','.','.','1','9','5','.','.','.'],
     * ['.','9','8','.','.','.','.','6','.'],
     * ['8','.','.','.','6','.','.','.','3'],
     * ['4','.','.','8','.','3','.','.','1'],
     * ['7','.','.','.','2','.','.','.','6'],
     * ['.','6','.','.','.','.','2','8','.'],
     * ['.','.','.','4','1','9','.','.','5'],
     * ['.','.','.','.','8','.','.','7','9']
     * ]
     * Output: false
     * Explanation: Same as Example 1, except with the 5 in the top left corner being
     * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
     * Note:
     * <p>
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     * The given board contain only digits 1-9 and the character '.'.
     * The given board size is always 9x9.
     *
     * @param board - input
     * @return true or false
     */
    static public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        if (m != n) return false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != '.') {
                    if (countInRow(board, i, board[i][j]) > 1) return false;
                    if (countInCol(board, j, board[i][j]) > 1) return false;
                    if (countInSubMat(board, i, j, board[i][j]) > 1) return false;
                }
            }
        }
        return true;
    }

    static public int countInRow(char[][] board, int r, char x) {
        int c = 0;
        for (int j = 0; j < board.length; ++j) {
            if (x == board[r][j]) c++;
        }
        return c;
    }

    static public int countInCol(char[][] board, int c, char x) {
        int cn = 0;
        for (int j = 0; j < board[0].length; ++j) {
            if (x == board[j][c]) cn++;
        }
        return cn;
    }

    static public int countInSubMat(char[][] board, int r, int c, char x) {
        int cn = 0;
        int ri = r - r % 3, ci = c - c % 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (x == board[i + ri][j + ci]) cn++;
            }
        }
        return cn;
    }

    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'3', '1', '6', '5', '7', '8', '4', '9', '2'},
                {'5', '2', '9', '1', '3', '4', '7', '6', '8'},
                {'4', '8', '7', '6', '2', '9', '5', '3', '1'},
                {'2', '6', '3', '4', '1', '5', '9', '8', '7'},
                {'9', '7', '4', '8', '6', '3', '1', '2', '5'},
                {'8', '5', '1', '7', '9', '2', '6', '4', '3'},
                {'1', '3', '8', '9', '4', '7', '2', '5', '6'},
                {'6', '9', '2', '3', '5', '1', '8', '7', '4'},
                {'7', '4', '5', '2', '8', '6', '3', '1', '9'},
        };
        System.out.println(isValidSudoku(a));
        a = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(a));
        a = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        System.out.println(isValidSudoku(a));
    }
}
