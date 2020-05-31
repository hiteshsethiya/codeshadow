package com.hitesh.test.leetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TopologicalSort {

    public static class Node {

        private int id;
        private boolean visited = false;
        private List<Node> adjacentNodes;

        public Node(int id) {
            this.id = id;
            this.adjacentNodes = new LinkedList<>();
            this.visited = false;
        }
//        double verify
//                oracle
//         integral ad science

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

}
