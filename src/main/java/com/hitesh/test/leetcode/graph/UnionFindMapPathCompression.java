package com.hitesh.test.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

public class UnionFindMapPathCompression {

    Map<Integer, Integer> f = new HashMap<>();

    public int find(int x) {
        f.putIfAbsent(x, x);
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
        }
    }
}
