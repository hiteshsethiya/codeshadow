package com.hitesh.test.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
// traverse the row right to left
        // traverse the column top to bottom
        // traverse the row left to right
        // traverse the column bottom to top
        int[][] a = new int[n][n];
        if (a.length == 0 || a[0].length == 0) return a;
        int counter = 1, count = n * n + 1;
        for (int i = 0; i <= n / 2; ++i) {
            int j = i;
            for (; j < (n - i); ++j) {
                a[i][j] = counter++;
            }
            if (count <= counter) break;
            --j;
            int k = i + 1;
            for (; k < (n - i); ++k) {
                a[k][j] = counter++;
            }
            if (count <= counter) break;
            // both at m - i - 1, n - i - 1
            --k;
            --j;
            for (; j >= i; --j) {
                a[k][j] = counter++;
            }
            if (count <= counter) break;
            ++j;
            --k;
            for (; k > i; --k) {
                a[k][j] = counter++;
            }
            if (count <= counter) break;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 1;
        int a[][] = generateMatrix(n);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        System.out.println();
        n = 2;
        a = generateMatrix(n);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        System.out.println();
        n = 0;
        a = generateMatrix(n);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        System.out.println();
        n = 3;
        a = generateMatrix(n);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        System.out.println();
        n = 4;
        a = generateMatrix(n);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        System.out.println();
        n = 5;
        a = generateMatrix(n);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        System.out.println();
        n = 10;
        a = generateMatrix(n);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println();
        System.out.println();
    }

}
