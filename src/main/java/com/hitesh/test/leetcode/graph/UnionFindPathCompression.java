package com.hitesh.test.leetcode.graph;

public class UnionFindPathCompression implements IUnionFindAlgo {

    private int[] id;

    public UnionFindPathCompression(int size) {
        this.id = new int[size];
        for (int i = 0; i < size; ++i)
            this.id[i] = i;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        id[pid] = qid;
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return id.length;
    }
}
