package com.hitesh.test.leetcode.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeightedGraphPrimMST {

    private boolean[] marked;
    private WeightedGraph graph;
    private PriorityQueue<WeightedEdge> pq;
    private Queue<WeightedEdge> mst;
    private double minWeight;

    public WeightedGraphPrimMST(WeightedGraph graph) {
        this.graph = graph;
        this.marked = new boolean[graph.V()];
        this.pq = new PriorityQueue<>();
        this.mst = new LinkedList<>();
        this.minWeight = 0;
    }

    public void mst(int s) {
        visit(s);
        while(!pq.isEmpty()) {
            WeightedEdge edge = pq.poll();
            int v = edge.V(), w = edge.W();
            if(this.marked[v] && this.marked[w]) continue;
            mst.add(edge);
            this.minWeight += edge.Weight();
            if(!this.marked[v]) visit(v);
            if(!this.marked[w]) visit(w);
        }
    }

    private void visit(int v) {
        this.marked[v] = true;
        for(WeightedEdge e : this.graph.adj(v)) {
            if(!marked[e.other(v)]) pq.add(e);
        }
    }

    public Iterable<WeightedEdge> mst() {
        return this.mst;
    }

    public double mstWeight() {
        return this.minWeight;
    }
}
