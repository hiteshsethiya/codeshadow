package com.hitesh.test.leetcode.matrix;

import java.util.*;

public class DiagonalTraverseII {

    /*
     * Given a list of lists of integers, nums, return all elements of
     * nums in diagonal order as shown in the below images.
     *
     * Example 1:
     *
     * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,4,2,7,5,3,8,6,9]
     *
     * Example 2:
     *
     * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
     * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
     *
     * Example 3:
     *
     * Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
     * Output: [1,4,2,5,3,8,6,9,7,10,11]
     * Example 4:
     *
     * Input: nums = [[1,2,3,4,5,6]]
     * Output: [1,2,3,4,5,6]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i].length <= 10^5
     * 1 <= nums[i][j] <= 10^9
     * There at most 10^5 elements in nums.
     */

    /*
    TIME's OUT
    public static void diagonalTraverse(int i, int j, int m, int n, List<List<Integer>> nums, int[] output, AtomicInteger k) {
        if (i < 0 || i > m || j < 0 || j > n) return;

        for (; i >= 0 && j < n; i--, j++) {
            if (j < nums.get(i).size()) {
                output[k.get()] = nums.get(i).get(j);
                k.incrementAndGet();
            }
        }
    }

    static public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) return new int[]{};
        int m = nums.size(), n = 0;
        int eCount = 0;
        for (List<Integer> i : nums) {
            n = Math.max(n, i.size());
            eCount += i.size();
        }
        int[] o = new int[eCount];
        AtomicInteger iA = new AtomicInteger(0);
        for (int i = 0; i < m; ++i) {
            diagonalTraverse(i, 0, m, n, nums, o, iA);
        }
        for (int i = 1; i < n; ++i) {
            diagonalTraverse(m - 1, i, m, n, nums, o, iA);
        }
        return o;
    }*/

    static class Tuple {
        int row;
        int col;

        public Tuple(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return row == tuple.row &&
                    col == tuple.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static final int[][] directions = new int[][] {
            {1, 0},
            {0, 1}
    };

    // The BFS Approach
    static public int[] findDiagonalOrder(List<List<Integer>> nums) {

        Queue<Tuple> queue = new LinkedList<>();
        Set<Tuple> visited = new HashSet<>();
        queue.add(new Tuple(0, 0));
        visited.add(queue.peek());
        List<Integer> o = new ArrayList<>();
        int m = nums.size();
        while(!queue.isEmpty()) {
            Tuple pop = queue.poll();
            o.add(nums.get(pop.row).get(pop.col));
            for (int[] direction : directions) {
                Tuple newEle = new Tuple(pop.row + direction[0], pop.col + direction[1]);
                if (newEle.row < m && newEle.col < nums.get(newEle.row).size()
                        && !visited.contains(newEle)) {
                    queue.add(newEle);
                    visited.add(newEle);
                }
            }
        }
        return o.stream().mapToInt(i -> i).toArray();
    }
}
