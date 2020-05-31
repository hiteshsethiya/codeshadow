package com.hitesh.test.coursera;

public class ConnectedComponents {
    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    public int count() {
        return this.count;
    }

    public int id(int v) {
        return this.id[v];
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        this.id[v] = this.count;
        for (Integer u : G.adj(v)) {
            if (!marked[u]) {
                dfs(G, u);
            }
        }
    }
}
