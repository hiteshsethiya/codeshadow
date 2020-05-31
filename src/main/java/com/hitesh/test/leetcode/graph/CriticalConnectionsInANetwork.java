package com.hitesh.test.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CriticalConnectionsInANetwork {

    /*
     * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections
     * forming a network where connections[i] = [a, b] represents a connection between servers a and b.
     * Any server can reach any other server directly or indirectly through the network.
     *
     * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
     *
     * Return all critical connections in the network in any order.
     *
     *
     *
     * Example 1:
     * IMAGE: https://assets.leetcode.com/uploads/2019/09/03/1537_ex1_2.png
     * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
     * Output: [[1,3]]
     * Explanation: [[3,1]] is also accepted.
     *
     *
     * Constraints:
     *
     * 1 <= n <= 10^5
     * n-1 <= connections.length <= 10^5
     * connections[i][0] != connections[i][1]
     * There are no repeated connections.
     */

    public static class Graph {

        final private int V;
        final private List<List<Integer>> adjacencyLists;

        public Graph(int v, List<List<Integer>> edges) {
            V = v;
            this.adjacencyLists = new ArrayList<>(v);
            for(int i = 0; i < v; ++i) {
                this.adjacencyLists.add(new ArrayList<>());
            }
            for(List<Integer> edge : edges) {
                Integer p = edge.get(0);
                Integer q = edge.get(1);
                adjacencyLists.get(p).add(q);
                adjacencyLists.get(q).add(p);
            }
        }

        public List<Integer> adj(int v) {
            return this.adjacencyLists.get(v);
        }

        public int V() {
            return this.V;
        }
    }

    private static final int UNVISITED = -1;
    private int[] low;
    private int[] ids;
    private int id = 0, sccCount = 0;
    private boolean[] onStack;
    private final Stack<Integer> stack = new Stack<>();
    Graph g;


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.g = new Graph(n, connections);
        this.ids = new int[n];
        this.low = new int[n];
        this.onStack = new boolean[n];
        Arrays.fill(this.ids, UNVISITED);
        for (int i = 0; i < g.V(); ++i) {
            if(ids[i] == UNVISITED) dfs(i, 0);
        }

        List<List<Integer>> criticalConnections = new ArrayList<>();
        for(List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            if(!isSameScc(u, v)) criticalConnections.add(edge);
        }

        return criticalConnections;
    }

    private void dfs(Integer at, Integer parent) {
        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = id++;

        for(int to : this.g.adj(at)) {
            if(to == parent) continue;
            if(ids[to] == UNVISITED) dfs(to, at);
            if(onStack[to]) low[at] = Math.min(low[at], low[to]);
        }

        if(low[at] == ids[at]) {
            for(int node = stack.pop();; node = stack.pop()) {
                onStack[node] = false;
                low[node] = ids[at];
                if(node == at) break;
            }
            this.sccCount++;
        }
    }

    private boolean isSameScc(int u, int v) {
        return this.low[u] == this.low[v];
    }

    public static void execute(int n, List<List<Integer>> connections) {
        CriticalConnectionsInANetwork criticalConnectionsInANetwork = new CriticalConnectionsInANetwork();
        List<List<Integer>> output = criticalConnectionsInANetwork.criticalConnections(n, connections);
        System.out.println(output);
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        execute(n, connections);
        n = 6;
        connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        connections.add(Arrays.asList(3,4));
        connections.add(Arrays.asList(4,5));
        connections.add(Arrays.asList(5,3));
        execute(n, connections);
    }

//    private static List<Integer> stringToIntegerList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        List<Integer> arr = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            arr.add(jsonArray.get(i).asInt());
//        }
//        return arr;
//    }
//
//    public static List<List<Integer>> stringToInt2dList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new ArrayList<List<Integer>>();
//        }
//
//        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            list.add(stringToIntegerList(cols.toString()));
//        }
//        return list;
//    }
//
//    public static String integerArrayListToString(List<Integer> nums, int length) {
//        if (length == 0) {
//            return "[]";
//        }
//
//        String result = "";
//        for(int index = 0; index < length; index++) {
//            Integer number = nums.get(index);
//            result += number + ", ";
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//
//    public static String integerArrayListToString(List<Integer> nums) {
//        return integerArrayListToString(nums, nums.size());
//    }
//
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(list);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int n = Integer.parseInt(line);
//            line = in.readLine();
//            List<List<Integer>> connections = stringToInt2dList(line);
//
//            List<List<Integer>> ret = new CriticalConnectionsInANetwork().criticalConnections(n, connections);
//
//            String out = int2dListToString(ret);
//
//            System.out.print(out);
//        }
//    }

}
