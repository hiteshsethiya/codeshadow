package com.hitesh.test.leetcode.graph;

public class GraphValidTreeUFArray {

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

    int[] uf;

    private void union(int u, int v) {
        int uid = root(u);
        int vid = root(v);
        if (uid != vid) {
            uf[vid] = uid;
        }
    }

    private int root(int u) {
        while (u != uf[u]) {
            uf[u] = uf[uf[u]];
            u = uf[u];
        }
        return u;
    }

    private boolean isConnected(int u, int v) {
        return root(u) == root(v);
    }

    public boolean validTree(int n, int[][] edges) {
        if (n == 1) return true;
        if (n > 1 && edges.length == 0) return false;
        if(edges.length != n - 1) return false;
        uf = new int[n];
        for (int i = 0; i < n; ++i) uf[i] = i;
        for (int[] iEdge : edges) {
            int u = iEdge[0];
            int v = iEdge[1];
            if (isConnected(u, v)) return false;
            union(u, v);
        }
        return true;
    }

    public static void execute(int n, int[][] edges, boolean exp) {
        boolean o = new GraphValidTreeUFArray().validTree(n, edges);
        System.out.println(exp == o);
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {2, 3}, {1, 2}};
        int n = 4;
        execute(n, edges, true);

        edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        n = 5;
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
