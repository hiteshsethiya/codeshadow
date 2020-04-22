package com.hitesh.test.leetcode.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LeftmostColumnWithAtLeastAOne {

    /*
     * (This problem is an interactive problem.)
     *
     * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
     *
     * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
     *
     * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
     *
     * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
     * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
     * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
     *
     * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
     *
     * Example 1:
     * Input: mat = [[0,0],[1,1]]
     * Output: 0
     *
     * Example 2:
     * Input: mat = [[0,0],[0,1]]
     * Output: 1
     *
     * Example 3:
     * Input: mat = [[0,0],[0,0]]
     * Output: -1
     *
     * Example 4:
     * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
     * Output: 1
     *
     * Constraints:
     *
     * 1 <= mat.length, mat[i].length <= 100
     * mat[i][j] is either 0 or 1.
     * mat[i] is sorted in a non-decreasing way.
     */

    public static interface BinaryMatrix {
        int get(int x, int y);

        List<Integer> dimensions();
    }

    /**
     * Since the input is sorted in increasing order row wise,
     * if there is a one in the row, the last column should have a one
     * 1. Iterate row wise until you find a one in the last column.
     * 2. Binary search on that row to find out the first column with 1.
     *
     * @param binaryMatrix - Interactive interface on the input matrix
     * @return - first column where we encounter a one
     */
    static public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> size = binaryMatrix.dimensions();
        int rows = size.get(0);
        int cols = size.get(1);
        int col = Integer.MAX_VALUE;
        for (int i = 0; i < rows; ++i) {
            if (binaryMatrix.get(i, cols - 1) == 1) {
                for (int l = 0, r = cols - 1; l <= r; ) {
                    int m = l + (r - l) / 2;
                    if (binaryMatrix.get(i, m) == 1) {
                        col = Integer.min(col, m);
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                if(col == 0) break; // break the row loop. if 0th column as a 1 then no point in looking for a lower column
            }
        }
        return col == Integer.MAX_VALUE ? -1 : col;
    }

    static void execute(int[][] a) {
        AtomicInteger calls = new AtomicInteger(0);
        BinaryMatrix binaryMatrix = new BinaryMatrix() {
            @Override
            public int get(int x, int y) {
                calls.getAndIncrement();
                return a[x][y];
            }

            @Override
            public List<Integer> dimensions() {
                return Arrays.asList(a.length, a[0].length);
            }
        };
        System.out.println(leftMostColumnWithOne(binaryMatrix));
        System.out.println(calls.get());
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        execute(a);
        a = new int[][]{
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}
        };
        execute(a);
        a = new int[][]{
                {0}
        };
        execute(a);
        a = new int[][]{
                {0, 0, 0, 1}
        };
        execute(a);
        a = new int[][]{
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 1},
        };
        execute(a);
    }

}
