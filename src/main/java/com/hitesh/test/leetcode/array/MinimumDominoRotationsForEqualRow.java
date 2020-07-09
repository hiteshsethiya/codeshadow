package com.hitesh.test.leetcode.array;

public class MinimumDominoRotationsForEqualRow {

    /*
     * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
     *
     * We may rotate the i-th domino, so that A[i] and B[i] swap values.
     *
     * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
     *
     * If it cannot be done, return -1.
     *
     * Example 1:
     *
     * Image: https://assets.leetcode.com/uploads/2019/03/08/domino.png
     *
     * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
     * Output: 2
     * Explanation:
     * The first figure represents the dominoes as given by A and B: before we do any rotations.
     * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
     * Example 2:
     *
     * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
     * Output: -1
     * Explanation:
     * In this case, it is not possible to rotate the dominoes to make one row of values equal.
     *
     *
     * Note:
     *
     * 1 <= A[i], B[i] <= 6
     * 2 <= A.length == B.length <= 20000
     */

    public void swap(int i, int[] a, int[] b) {
        int t = a[i];
        a[i] = b[i];
        b[i] = t;
    }



    public int rotations(int[] a, int[] b) {
        int n = a.length, rotations = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (!isPossible(i, a, b)) return -1;
            if (a[i] == a[i + 1]) continue;
            if (a[i] != a[i + 1]) {
                rotations++;
                if (a[i + 1] == b[i]) {
                    swap(i, a, b);
                } else {
                    swap(i + 1, a, b);
                }
            }
        }
        return rotations;
    }

    public boolean isPossible(int i, int[] a, int[] b) {
        if(i + 1 >= a.length) return true;
        return (a[i] == a[i + 1])
                || (b[i] == b[i + 1])
                || (a[i] == b[i + 1])
                || (b[i] == a[i + 1]);
    }

    public int minDominoRotations(int[] a, int[] b) {
        if (a.length <= 1) return 0;
        int n = a.length;
        int[] eleA = new int[7];
        int[] eleB = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < n; ++i) {
            if(!isPossible(i, a, b)) return -1;
            eleA[a[i]]++;
            eleB[b[i]]++;
            if(a[i] == b[i]) same[a[i]]++;
        }
        for (int i = 1; i < 7; ++i) {
            if(eleA[i] + eleB[i] - same[i] == n) {
                return n - Math.max(eleA[i], eleB[i]);
            }
        }
        return -1;
    }

    public static void execute(int[] a, int[] b, int ans) {
        int o = new MinimumDominoRotationsForEqualRow().minDominoRotations(a, b);
        System.out.println(o);
        System.out.println(o == ans);
    }

    public static void main(String[] args) {
        execute(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}, 1);
        execute(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 1, 1}, 0);
        execute(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}, 2);
        execute(new int[]{5, 2, 6, 2, 3, 2}, new int[]{2, 1, 2, 4, 2, 2}, 2);
        execute(new int[]{2, 1, 2, 4, 2, 2}, new int[]{2, 1, 2, 4, 2, 2}, -1);
        execute(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}, -1);
        execute(new int[]{1}, new int[]{2}, 0);
    }


}
