package com.hitesh.test.leetcode.matrix;

public class SeachA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0, j = n - 1; i < m && j >= 0; ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        System.out.println(searchMatrix(a, 3));
        System.out.println(searchMatrix(a, 100));
        System.out.println(searchMatrix(new int[0][0], 100));
    }

}
