package com.hitesh.test.coursera;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private final int V;
    private List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        this.adj = new ArrayList<>(this.V);
        for (int v = 0; v < V; v++)
            this.adj.add(v, new LinkedList<>());
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public Iterable<Integer> adj(int v) {
        if(this.adj == null) return null;
        return adj.get(v);
    }

    public int V() {
        return this.V;
    }


}
