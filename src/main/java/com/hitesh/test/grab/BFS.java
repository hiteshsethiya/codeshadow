package com.hitesh.test.grab;

import java.util.*;

public class BFS {

    /**
     * Given N*M matrix. Need to find if a person can go from (0,0) to (n-1, n-1)
     * Conditions:
     * 1. Can only go to block with 1 in the cell
     * 2. Can only go right or down
     *
     * {1, 1, 1, 0}
     * {1, 1, 0, 1}
     * {0, 1, 0, 0}
     * {1, 1, 1, 1}
     *
     * The matrix will contain only 0 and 1.
     * 1 -> is the go to cell.
     * N , M -> 1000, 1000
     *
     */

    static final int[][] DIRECTIONS = new int[][]{
            {0, 1}, // right
            {1, 0}, // down
    };

    static class Tuple {

        public int row;
        public int column;

        public Tuple(int r, int c) {
            this.row = r;
            this.column = c;
        }

    }

    public static boolean isInBound(int row, int column, int totalRows, int totalColumns) {
        return row >= 0 && row < totalRows && column >= 0 && column <= totalColumns;
    }

    public static List<Tuple> canGo(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 0) return null;

        int rows = grid.length, columns = grid[0].length;

        if (grid[rows - 1][columns - 1] == 0) return null;

        final Queue<Tuple> bfsQueue = new LinkedList<>();
        final Tuple start = new Tuple(0, 0);
        bfsQueue.add(start);

        Set<Tuple> visited = new HashSet<>();
        visited.add(start);

        Map<Tuple, Tuple> toAndFromPath = new HashMap<>();

        outer:
        while (!bfsQueue.isEmpty()) {

            Tuple iPosition = bfsQueue.poll();
            for (int[] iDirection : DIRECTIONS) {
                int neighbourRow = iPosition.row + iDirection[0];
                int neighbourColumn = iPosition.column + iDirection[1];

                if (isInBound(neighbourRow, neighbourColumn, rows, columns)) {

                    Tuple neighbourTuple = new Tuple(neighbourRow, neighbourColumn);

                    if (!visited.contains(neighbourTuple) && grid[neighbourRow][neighbourColumn] == 1) {

                        toAndFromPath.put(neighbourTuple, iPosition);
                        if (neighbourRow == rows - 1 && neighbourColumn == columns - 1) {
                            break outer;
                        }

                        bfsQueue.add(neighbourTuple);
                    }
                    visited.add(neighbourTuple);
                }

            }

        }

        LinkedList<Tuple> path = new LinkedList<>();
        Tuple destination = new Tuple(rows - 1, columns - 1);
        if(toAndFromPath.containsKey(destination)) {

            for(Tuple iCurrentPosition = destination; iCurrentPosition.equals(start);) {
                path.addLast(iCurrentPosition);
                iCurrentPosition = toAndFromPath.get(iCurrentPosition);
            }

        }

        return path;

    }

}
