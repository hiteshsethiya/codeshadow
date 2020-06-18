package com.hitesh.test.leetcode.matrix;

import java.util.Stack;

public class MaximalRectangle {

    /*
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     * [
     *   ["1","0","1","0","0"],
     *   ["1","0","1","1","1"],
     *   ["1","1","1","1","1"],
     *   ["1","0","0","1","0"]
     * ]
     * Output: 6
     */

    public boolean isEmpty(int[] a) {
        return a == null || a.length == 0;
    }

    public int maxHistogramArea(int[] histogram) {
        if (isEmpty(histogram)) return 0;
        int n = histogram.length, area = 0, maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (stack.isEmpty() || histogram[i] >= histogram[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int poppedIdx = stack.pop();
                if (stack.isEmpty()) {
                    area = histogram[poppedIdx] * i;
                } else {
                    area = histogram[poppedIdx] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!stack.isEmpty()) {
            int poppedIdx = stack.pop();
            if (stack.isEmpty()) {
                area = histogram[poppedIdx] * i;
            } else {
                area = histogram[poppedIdx] * (i - stack.peek() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        int[][] histogramMatrix = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0) histogramMatrix[i][j] = matrix[i][j] - '0';
                else if (matrix[i][j] == '1') {
                    histogramMatrix[i][j] = matrix[i][j] - '0' + histogramMatrix[i - 1][j];
                }
            }
            maxArea = Math.max(maxArea, maxHistogramArea(histogramMatrix[i]));
        }
        return maxArea;
    }

}
