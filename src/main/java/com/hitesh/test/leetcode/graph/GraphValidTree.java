package com.hitesh.test.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {

    /*
     * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to check whether these edges make up a valid tree.
     *
     * Example 1:
     *
     * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
     * Output: true
     *
     * Example 2:
     *
     * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
     * Output: false
     *
     * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected,
     * [0,1] is the same as [1,0] and thus will not appear together in edges.
     */

    Map<Integer, Set<Integer>> graph;

    private boolean isCyclic(Set<Integer> visited, int src, Integer parent) {
        visited.add(src);
        if (graph.getOrDefault(src, new HashSet<>()).isEmpty()) return true;
        for (Integer iNeighbor : graph.get(src)) {
            if (!visited.contains(iNeighbor)) {
                if (isCyclic(visited, iNeighbor, src)) return true;
            } else if (!iNeighbor.equals(parent)) {
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return true;
        if (n > 1 && edges.length == 0) return false;
        graph = new HashMap<>();
        for (int[] iEdge : edges) {
            graph.computeIfAbsent(iEdge[0], k -> new HashSet<>()).add(iEdge[1]);
            graph.computeIfAbsent(iEdge[1], k -> new HashSet<>()).add(iEdge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        boolean notCyclic = !isCyclic(visited, 0, 0);
        return visited.size() == n && notCyclic;
    }

    public static void execute(int n, int[][] edges, boolean exp) {
        boolean o = new GraphValidTree().validTree(n, edges);
        System.out.println(exp == o);
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        execute(n, edges, true);

        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        n = 5;
        execute(n, edges, false);

        edges = new int[][]{{0, 1}, {2, 3}};
        n = 4;
        execute(n, edges, false);
        edges = new int[][]{{2, 3}, {1, 2}, {1, 3}};
        n = 4;
        execute(n, edges, false);
        edges = new int[0][0];
        n = 1;
        execute(n, edges, true);
        edges = new int[][]{{1, 0}};
        n = 3;
        execute(n, edges, false);
        edges = new int[0][0];
        n = 2;
        execute(n, edges, false);
    }

}
