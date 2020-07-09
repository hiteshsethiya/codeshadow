package com.hitesh.test.leetcode.graph;

public interface IUnionFindAlgo {

    boolean connected(int p, int q); // are p and q in the same component?
    void union(int p, int q); // add connection between p and q
    int find(int p); // component identifier for p (0 to N – 1)
    int count(); // number of components
}
