package com.hitesh.test.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraversal {

    public static List<Integer> spiral(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        List<Integer> spiral = new ArrayList<>(m * n);
        for (int ubxi = m, lbxi = 0, lbxj = 0, ubxj = n; lbxi < ubxj && lbxj < ubxj; ubxi--, ubxj--, lbxi++, lbxj++) {
            int i = lbxi, j = lbxj;
            for (; j < ubxj; ++j) {
//                System.out.print(a[i][j] + " ");
                spiral.add(a[i][j]);
            }
            i++;
            j--;
            for (; i < ubxi; ++i) {
//                System.out.print(a[i][j] + " ");
                spiral.add(a[i][j]);
            }
            i--;
            j--;
            for (; j >= lbxj; --j) {
//                System.out.print(a[i][j] + " ");
                spiral.add(a[i][j]);
            }
            j++;
            --i;
            for (; i > lbxi; --i) {
//                System.out.print(a[i][j] + " ");
                spiral.add(a[i][j]);
            }
        }
        return spiral;
    }

    public static int swapAndReturn(int[][] a, int i, int j, int var) {
        int temp = a[i][j];
        a[i][j] = var;
        return temp;
    }

    public static void rotate(int[][] a) {
        int m = a.length - 1;
        int n = a[0].length - 1;
        if (m != n) return; // Has to be a square matrix
        for (int i = 0; i < a.length / 2; ++i) {
            for (int j = i; j < n - i; ++j) {
                int temp = a[i][j];
                temp = swapAndReturn(a, j, (n - i), temp);
                temp = swapAndReturn(a, (n - i), (n - j), temp);
                temp = swapAndReturn(a, (n - j), i, temp);
                swapAndReturn(a, i, j, temp);
            }
        }
    }

    public static void debugRotate(int[][] a) {
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; ++i) {
            b[i] = Arrays.copyOf(a[i], a[i].length);
        }
        rotate(a);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(b[i]) + "       " + Arrays.toString(a[i]));
        }
        System.out.println();
        System.out.println();
    }

    public static int[][] inputGenerator(int m, int n) {
        int[][] a = new int[m][n];
        int c = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = c++;
            }
        }
        return a;
    }

    public static List<Integer> spiral2(int[][] a) {
        // traverse the row right to left
        // traverse the column top to bottom
        // traverse the row left to right
        // traverse the column bottom to top
        List<Integer> spiral = new ArrayList<>();
        if (a.length == 0 || a[0].length == 0) return spiral;
        int m = a.length, n = a[0].length, count = m * n;
        for (int i = 0; i <= m / 2; ++i) {
            int j = i;
            for (; j < (n - i); ++j) {
                spiral.add(a[i][j]);
                count--;
            }
            if (count == 0) break;
            --j;
            int k = i + 1;
            for (; k < (m - i); ++k) {
                spiral.add(a[k][j]);
                count--;
            }
            if (count == 0) break;
            // both at m - i - 1, n - i - 1
            --k;
            --j;
            for (; j >= i; --j) {
                spiral.add(a[k][j]);
                count--;
            }
            if (count == 0) break;
            ++j;
            --k;
            for (; k > i; --k) {
                spiral.add(a[k][j]);
                count--;
            }
            if (count == 0) break;
        }
        return spiral;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
        System.out.println(spiral2(a));
        a = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[] b = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        System.out.println(spiral2(a));
        a = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };
        System.out.println(spiral2(a));
        a = new int[][]{
                {1, 2, 3, 4, 5}
        };
        System.out.println(spiral2(a));
        a = new int[][]{
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        System.out.println(spiral2(a));
        System.out.println(spiral2(new int[0][0]));
        /*a = new int[][]{
                {2, 3, 4, 5},
                {6, 7, 8, 9},
                {11, 12, 13, 14},
                {17, 18, 19, 20}
        };
        debugRotate(a);
        a = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        debugRotate(a);
        a = new int[][]{
                {1, 2},
                {4, 5}
        };
        debugRotate(a);*/
}

}
