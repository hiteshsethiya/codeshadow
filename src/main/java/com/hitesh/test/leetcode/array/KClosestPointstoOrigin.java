package com.hitesh.test.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    /*
     * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
     *
     * (Here, the distance between two points on a plane is the Euclidean distance.)
     *
     * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
     *
     *
     *
     * Example 1:
     *
     * Input: points = [[1,3],[-2,2]], K = 1
     * Output: [[-2,2]]
     * Explanation:
     * The distance between (1, 3) and the origin is sqrt(10).
     * The distance between (-2, 2) and the origin is sqrt(8).
     * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
     * Example 2:
     *
     * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
     * Output: [[3,3],[-2,4]]
     * (The answer [[-2,4],[3,3]] would also be accepted.)
     *
     *
     * Note:
     *
     * 1 <= K <= points.length <= 10000
     * -10000 < points[i][0] < 10000
     * -10000 < points[i][1] < 10000
     */

    public int square(int a) {
        return a * a;
    }

    public double getEuclideanDistance(int[] a) {
        return Math.sqrt(square(a[0]) + square(a[1]));
    }

    public int[][] kClosest(int[][] points, int K) {
        if (K == 0 || points == null || points.length == 0) return new int[0][0];
        int[][] closestPoints = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Double.compare(getEuclideanDistance(a), getEuclideanDistance(b));
            }
        });
        pq.addAll(Arrays.asList(points));
        int i = 0;
        while (K-- > 0 && !pq.isEmpty()) {
            closestPoints[i++] = pq.poll();
        }
        return closestPoints;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {3, 3}, {5, -1}, {-2, 4}
        };
        System.out.println(Arrays.deepToString(new KClosestPointstoOrigin().kClosest(points, 2)));
    }

}
