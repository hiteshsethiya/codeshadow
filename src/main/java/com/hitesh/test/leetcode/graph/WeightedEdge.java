package com.hitesh.test.leetcode.graph;

public class WeightedEdge implements Comparable<WeightedEdge> {

    private double weight;
    private int v;
    private int w;

    public WeightedEdge(int v, int w, double weight) {
        this.weight = weight;
        this.v = v;
        this.w = w;
    }

    public double Weight() {
        return weight;
    }

    public int V() {
        return v;
    }

    public int W() {
        return w;
    }

    public int other(int e) {
        return e == v ? w : v;
    }

    @Override
    public int compareTo(WeightedEdge weightedEdge) {
        return Double.compare(this.weight, weightedEdge.weight);
    }
}
