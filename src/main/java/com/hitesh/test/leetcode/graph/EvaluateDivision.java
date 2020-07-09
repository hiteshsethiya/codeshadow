package com.hitesh.test.leetcode.graph;

import java.util.*;

public class EvaluateDivision {

    /*
     * Equations are given in the format A / B = k, where A and B are variables represented as strings,
     * and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
     *
     * Example:
     * Given a / b = 2.0, b / c = 3.0.
     * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
     * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
     *
     * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries,
     * where equations.size() == values.size(), and the values are positive.
     * This represents the equations. Return vector<double>.
     *
     * According to the example above:
     *
     * equations = [ ["a", "b"], ["b", "c"] ],
     * values = [2.0, 3.0],
     * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
     *
     *
     *
     * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
     *
     * Hint1: Do you recognize this as a graph problem?
     *
     */

    public double query(Map<String, Map<String, Double>> graph,
                        Set<String> visited,
                        String op1, String op2) {
        if (!graph.containsKey(op1)) return -1.0;
        if (op1.equals(op2)) return 1.0;
        if (graph.get(op1).containsKey(op2)) return graph.get(op1).get(op2);
        visited.add(op1);
        for (Map.Entry<String, Double> neighbors : graph.get(op1).entrySet()) {
            if (!visited.contains(neighbors.getKey())) {
                double product = query(graph, visited, neighbors.getKey(), op2);
                if (product != -1.0) {
                    return product * neighbors.getValue();
                }
            }
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            String op1 = equations.get(i).get(0);
            String op2 = equations.get(i).get(1);
            double weight = values[i];
            graph.computeIfAbsent(op1, k -> new HashMap<>()).put(op2, weight);
            graph.computeIfAbsent(op2, k -> new HashMap<>()).put(op1, 1.0 / weight);
        }
        double[] output = new double[queries.size()];

        for (int i = 0; i < queries.size(); ++i) {
            String op1 = queries.get(i).get(0);
            String op2 = queries.get(i).get(1);
            output[i] = query(graph, new HashSet<>(), op1, op2);
        }

        return output;
    }

    public static void execute(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] o = new EvaluateDivision().calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(o));
    }

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        execute(equations, values, queries);
    }

}
