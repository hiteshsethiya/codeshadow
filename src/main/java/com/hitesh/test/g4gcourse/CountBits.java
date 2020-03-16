package com.hitesh.test.g4gcourse;

import java.util.HashMap;
import java.util.Map;

public class CountBits {

    //Find the total count of set bits for all numbers from 1 to N(both inclusive).
    private static final Map<Integer, Integer> CACHE = new HashMap<>();

    public static int getTotalSetBits(int i) {
        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            ++count;
        }
        return count;
    }

    // Function to count number of set bits
    public static int countSetBits(int n) {

        if (n == 0) return 0;

        if (n == 1) return 1;

        if (CACHE.containsKey(n)) {
            return CACHE.get(n);
        }

        // Your code here
        int val = getTotalSetBits(n) + countSetBits(n - 1);
        CACHE.put(n, val);
        return val;
    }
}