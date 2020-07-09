package com.hitesh.test.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PathCrossing {


    public static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r &&
                    c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Pair pair = new Pair(x, y);
        Set<Pair> v = new HashSet<>();
        v.add(pair);
        for (int i = 0; i < path.length(); ++i) {
            char c = path.charAt(i);
            switch (c) {
                case 'N': {
                    y++;
                }
                break;
                case 'E': {
                    x++;
                }
                break;
                case 'S': {
                    y--;
                }
                break;
                case 'W': {
                    x--;
                }
                break;
            }
            if(!v.add(new Pair(x, y))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PathCrossing().isPathCrossing("NESWW"));
        System.out.println(new PathCrossing().isPathCrossing("NSWW"));
        System.out.println(new PathCrossing().isPathCrossing("NSEWW"));
        System.out.println(new PathCrossing().isPathCrossing("NSE"));
        int[] a = new int[10];
        double sum = Arrays.stream(a).average().orElse(0.0);
    }

    /*int mod = (int) (Math.pow(2, 10) + 7);
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[n - 1] + nums[n - 2] <= target) return (int) ((Math.pow(2, n) - 1) % mod);
        for(int j = n - 1; j >= 0; ++j) {

        }
    }*/

}
