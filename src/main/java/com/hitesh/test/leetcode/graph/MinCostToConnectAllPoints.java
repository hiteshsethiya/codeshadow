package com.hitesh.test.leetcode.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    int[] unionFind;

    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1) return 0;
        int n = points.length;
        unionFind = new int[n];
        for (int i = 0; i < n; ++i) unionFind[i] = i;
        int[][] dist = new int[n][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a[0]][a[1]]));
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                dist[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                heap.offer(new int[]{i, j});
            }
        }
        int cost = 0;
        while (!heap.isEmpty() && n > 1) {
            int[] p = heap.poll();
            if (union(p[0], p[1])) {
                n--;
                cost += dist[p[0]][p[1]];
            }
        }
        return cost;
    }

    public boolean union(int i, int j) {
        int ip = find(i), jp = find(j);
        if (ip == jp) return false;
        unionFind[ip] = jp;
        return true;
    }

    public int find(int i) {
        int ip = unionFind[i];
        if (i != ip) unionFind[i] = find(ip);
        return unionFind[i];
    }

    public static void main(String[] args) {
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(
                new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}
        ));
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(
                new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}
        ));
    }

}
