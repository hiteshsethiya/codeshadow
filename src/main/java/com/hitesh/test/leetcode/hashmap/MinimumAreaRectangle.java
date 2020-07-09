package com.hitesh.test.leetcode.hashmap;

import java.util.*;

public class MinimumAreaRectangle {

    /*
     * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points,
     * with sides parallel to the x and y axes.
     *
     * If there isn't any rectangle, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
     * Output: 4
     * Example 2:
     *
     * Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
     * Output: 2
     *
     *
     * Note:
     *
     * 1 <= points.length <= 500
     * 0 <= points[i][0] <= 40000
     * 0 <= points[i][1] <= 40000
     * All points are distinct.
     */

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xPoints = new HashMap<>();
        for(int[] i : points) {
            xPoints.computeIfAbsent(i[0], k -> new HashSet<>()).add(i[1]);
        }
        int minArea = Integer.MAX_VALUE;
        for(int[] p1 : points) {
            for(int[] p2 : points) {
                int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];
                if(x1 == x2 || y1 == y2) continue;
                if(xPoints.get(x1).contains(y2) && xPoints.get(x2).contains(y1)) {
                    minArea = Math.min(
                      minArea,
                      Math.abs(y2 - y1) * Math.abs(x2 - x1)
                    );
                }
            }
        }
        return minArea % Integer.MAX_VALUE;
    }



}
