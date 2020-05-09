package com.hitesh.test.leetcode.matrix;

import java.util.Arrays;
import java.util.List;

public class MatrixUtil {

    public static void soutMatrix(int[][] a) {
        for (int[] i : a) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void soutMatrix(char[][] a) {
        for (char[] i : a) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void soutMatrix(List<List<Integer>> ans) {
        for(List<Integer> i : ans) {
            System.out.println(i);
        }
    }
}
