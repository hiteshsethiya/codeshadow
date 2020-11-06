package com.hitesh.test.leetcode.graph;

import java.util.*;

public class PathWithMinimumEffort {

    /*static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, // right
            {1, 0}, // down
            {0, -1},// left
            {-1, 0} // up
    };

    public void bfs(int[][] heights, <Integer> pq, int r, int c) {

    }

    static class Tuple {
        int r;
        int c;

        public Tuple(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return r == tuple.r &&
                    c == tuple.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public void relax(int[][] heights, Tuple from, Tuple to,
                      PriorityQueue<Tuple> pq, Set<Tuple> onPq, Map<Tuple, Integer> dist) {
        if(dist.getOrDefault(to, Integer.MAX_VALUE) > (Math.abs(dist.get(from) - heights[from.r][from.c]))) {
            dist.put(to, Math.abs(dist.get(from) - heights[from.r][from.c]));
            if(onPq.contains(to)) pq.
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length, V = m * n;
        Map<Tuple, Integer> dist = new HashMap<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>(V, (a, b) -> Math.abs(heights[a.r][a.c] - heights[b.r][b.c]));
        Set<Tuple> onPq = new HashSet<>();

        Tuple start = new Tuple(0, 0);
        pq.offer(start);
        onPq.add(start);
        dist.put(start, 0);

        while (!pq.isEmpty()) {
            Tuple v = pq.poll();
            onPq.remove(v);
            int i = v.r, j = v.c;
            for (int k = 0; k < DIRECTIONS.length; ++k) {
                int r = i + DIRECTIONS[k][0];
                int c = j + DIRECTIONS[k][1];
                if (r < 0 || c < 0 || c >= heights[0].length || r >= heights.length) continue;
                relax()
            }
        }
    }*/

}
