package com.hitesh.test.leetcode.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost {

    /**
     * There are N cities numbered from 1 to N.
     * <p>
     * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
     * <p>
     * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * IMAGE: https://assets.leetcode.com/uploads/2019/04/20/1314_ex2.png
     * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
     * Output: 6
     * Explanation:
     * Choosing any 2 edges will connect all cities so we choose the minimum 2.
     * <p>
     * Example 2:
     * IMAGE: https://assets.leetcode.com/uploads/2019/04/20/1314_ex1.png
     * Input: N = 4, connections = [[1,2,3],[3,4,4]]
     * Output: -1
     * Explanation:
     * There is no way to connect all cities even if all edges are used.
     * <p>
     * <p>
     * <p>
     * Note:
     * <p>
     * 1 <= N <= 10000
     * 1 <= connections.length <= 10000
     * 1 <= connections[i][0], connections[i][1] <= N
     * 0 <= connections[i][2] <= 10^5
     * connections[i][0] != connections[i][1]
     */

    private WeightedGraph cityGraph;

    public void createGraph(int N, int[][] connections) {
        this.cityGraph = new WeightedGraph(N);
        for (int i = 0; i < connections.length; ++i) {
            this.cityGraph.addEdge(
                    new WeightedEdge(
                            --connections[i][0], // v
                            --connections[i][1], // w
                            connections[i][2]  // weight
                    )
            );
        }
    }

    public int minimumCost(int N, int[][] connections) {
        createGraph(N, connections);
        WeightedGraphPrimMST prims = new WeightedGraphPrimMST(
                this.cityGraph
        );
        prims.mst(0);
        if(prims.isSingleConnectedComponent()) {
            return prims.mstWeight();
        }
        return -1;
    }

    public static class WeightedGraphPrimMST {

        private boolean[] marked;
        private WeightedGraph graph;
        private PriorityQueue<WeightedEdge> pq;
        private int minWeight;
        private boolean isForest;

        public WeightedGraphPrimMST(WeightedGraph graph) {
            this.graph = graph;
            this.marked = new boolean[graph.V()];
            this.pq = new PriorityQueue<>();
            this.minWeight = 0;
        }

        public void mst(int s) {
            visit(s);
            while(!pq.isEmpty()) {
                WeightedEdge edge = pq.poll();
                int v = edge.V(), w = edge.W();
                if(this.marked[v] && this.marked[w]) continue;
                this.minWeight += edge.Weight();
                if(!this.marked[v]) visit(v);
                if(!this.marked[w]) visit(w);
            }
            for (boolean b : marked) {
                if (!b) {
                    isForest = true;
                    break;
                }
            }
        }

        private void visit(int v) {
            this.marked[v] = true;
            for(WeightedEdge e : this.graph.adj(v)) {
                if(!marked[e.other(v)] && v != e.other(v)) pq.add(e);
            }
        }

        public int mstWeight() {
            return this.minWeight;
        }
        
        public boolean isSingleConnectedComponent() {
            return !this.isForest;
        }
    }

    public static class WeightedEdge implements Comparable<WeightedEdge> {

        private int weight;
        private int v;
        private int w;

        public WeightedEdge(int v, int w, int weight) {
            this.weight = weight;
            this.v = v;
            this.w = w;
        }

        public int Weight() {
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
            return Integer.compare(this.weight, weightedEdge.Weight());
        }
    }
    
    public static class WeightedGraph {

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
}
