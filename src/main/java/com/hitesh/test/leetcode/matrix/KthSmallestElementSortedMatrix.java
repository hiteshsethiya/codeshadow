package com.hitesh.test.leetcode.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

    public static class Triplet {
        int value;
        int row;
        int col;

        public Triplet(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    static public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0
                || k < 1 || k > matrix.length * matrix[0].length) return -1;
        PriorityQueue<Triplet> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            heap.offer(new Triplet(matrix[i][0], i, 0));
        }
        while (!heap.isEmpty() && k > 0) {
            Triplet triplet = heap.poll();
            if (--k == 0) return triplet.value;
            if (triplet.col + 1 < n) {
                heap.offer(new Triplet(matrix[triplet.row][triplet.col + 1], triplet.row, triplet.col + 1));
            }
        }
        return -1;
    }

    public static void execute(int[][] mat, int k, int exp) {
        int ans = kthSmallest(mat, k);
        MatrixUtil.soutMatrix(mat);
        System.out.println(ans);
        System.out.println(ans == exp);
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        execute(a, 8, 13);
        execute(a, 1, 1);
        execute(a, 9, 15);
        execute(a, 5, 11);
    }

}
