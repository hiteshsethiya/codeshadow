package com.hitesh.test.leetcode.graph;

import java.util.LinkedList;

public class WeightedGraph {

    private int V;
    private LinkedList<WeightedEdge>[] adj;

    public WeightedGraph(int v) {
        this.V = v;
        this.adj = new LinkedList[this.V];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public int V() {
        return V;
    }

    public LinkedList<WeightedEdge> adj(int v) {
        return adj[v];
    }

    public void addEdge(WeightedEdge edge) {
        this.adj(edge.V()).add(edge);
        this.adj(edge.W()).add(edge);
    }
}
