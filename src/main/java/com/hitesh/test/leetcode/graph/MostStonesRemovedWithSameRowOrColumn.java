package com.hitesh.test.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {

    /*
     * On a 2D plane, we place stones at some integer coordinate points.
     * Each coordinate point may have at most one stone.
     *
     * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
     *
     * What is the largest possible number of moves we can make?
     *
     *
     *
     * Example 1:
     *
     * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
     * Output: 5
     * Example 2:
     *
     * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
     * Output: 3
     * Example 3:
     *
     * Input: stones = [[0,0]]
     * Output: 0
     *
     *
     * Note:
     *
     * 1 <= stones.length <= 1000
     * 0 <= stones[i][j] < 10000
     */


    Map<Integer, Set<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public void dfs(Integer i) {
        if(visited.add(i)) {
            for(Integer neighbor : graph.get(i)) {
                dfs(neighbor);
            }
        }
    }

    public int removeStones(int[][] stones) {
        if (stones.length <= 1) return 0;
        for (int[] i : stones) {
            int u = i[0];
            int v = ~i[1];
            graph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            graph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }
        System.out.println(graph);
        int connectedComponents = 0;
        for(Map.Entry<Integer, Set<Integer>> i : this.graph.entrySet()) {
            if(!visited.contains(i.getKey())) {
                connectedComponents++;
                dfs(i.getKey());
            }
        }
        return stones.length - connectedComponents;
    }

    public static void main(String[] args) {
        System.out.println(~5);
        int[][] m = new int[][]{
                {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}
        };
        System.out.println(new MostStonesRemovedWithSameRowOrColumn().removeStones(m));

        m = new int[][]{
                {0, 0},
                {1, 1},
                {1, 2},
                {3, 4},
                {4, 4},
                {5, 4}
        };
        System.out.println(new MostStonesRemovedWithSameRowOrColumn().removeStones(m));
        m = new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {2, 1}
        };
        System.out.println(new MostStonesRemovedWithSameRowOrColumn().removeStones(m));
        m = new int[][]{
                {0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}
        };
        System.out.println(new MostStonesRemovedWithSameRowOrColumn().removeStones(m));
    }
}