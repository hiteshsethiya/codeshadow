package com.hitesh.test.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    final private int V;
    final private List<List<T>> adjacencyLists;

    public Graph(int v, List<List<T>> adjacencyLists) {
        V = v;
        this.adjacencyLists = adjacencyLists;
    }

    public List<T> adj(int v) {
        return this.adjacencyLists.size() > v ? this.adjacencyLists.get(v) : new ArrayList<>();
    }

    public int V() {
        return this.V;
    }
}
