package com.hitesh.test.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Contest {

    static public List<Integer> mostVisited(int n, int[] rounds) {

        if (n == 0) return new ArrayList<>();

        TreeMap<Integer, Integer> max = new TreeMap<>();
        max.put(rounds[0], 1);
        for (int i = 1; i < rounds.length; ++i) {
            int prev = rounds[i - 1];
            if (prev == rounds[i]) continue;
            if (prev > rounds[i]) {
                int l = ((prev + rounds[i]) % n) + 1;
                for (int j = prev + 1, c = 0; c < l; c++, j++) {
                    if (j == n) j = 1;
                    max.put(j, max.getOrDefault(j, 0) + 1);
                }
            } else {
                int l = (rounds[i] - prev) % n;
                for (int j = prev + 1, c = 0; c < l; c++, j++) {
                    if (j == n) j = 1;
                    max.put(j, max.getOrDefault(j, 0) + 1);
                }
            }
        }
        int maxC = max.firstEntry().getValue();
        return max.entrySet().stream().filter(i -> i.getValue() == maxC).map(Map.Entry::getKey).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        System.out.println(mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
    }
}
