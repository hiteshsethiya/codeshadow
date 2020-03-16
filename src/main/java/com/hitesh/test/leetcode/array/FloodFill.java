package com.hitesh.test.leetcode.array;

import java.util.Arrays;

public class FloodFill {

    public static int[][] flood(int[][] image, int sr, int sc, int newColor, int color, boolean[][] v) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || v[sr][sc]) {
            return image;
        }
        v[sr][sc] = true;
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr - 1 >= 0) {
                flood(image, sr - 1, sc, newColor, color, v);
            }

            if (sr + 1 < image.length) {
                flood(image, sr + 1, sc, newColor, color, v);
            }

            if (sc - 1 >= 0) {
                flood(image, sr, sc - 1, newColor, color, v);
            }

            if (sc + 1 < image[0].length) {
                flood(image, sr, sc + 1, newColor, color, v);
            }
        }
        return image;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }
        boolean[][] v = new boolean[image.length][image[0].length];
        return flood(image, sr, sc, newColor, image[sr][sc], v);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(a, 1, 1, 2);
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
