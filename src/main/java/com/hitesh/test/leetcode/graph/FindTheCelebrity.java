package com.hitesh.test.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheCelebrity {

    public static class Relation {
        boolean knows(int a, int b) {
            return true;
        }
    }

    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int candi = 0;
            for(int i = 1; i < n; ++i) {
                if(knows(candi, i)) {
                    candi = i;
                }
            }
            for(int i = 0; i < n; ++i) {
                if(candi != i && knows(candi, i) || !knows(i, candi)) return -1;
            }
            return 1;
        }
    }

}
