package com.hitesh.test.coursera;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstPaths(Graph G) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }
}
