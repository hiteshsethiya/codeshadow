package com.hitesh.test.leetcode.array;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 1;
        int degree = 1, minLength = Integer.MAX_VALUE;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i}); // Add the lowest position
            } else {
                int[] tuple = map.get(nums[i]);
                int deg = ++tuple[0];
                if (deg > degree) {
                    minLength = i - tuple[1] + 1;
                    degree = deg;
                } else if(deg == degree) {
                    minLength = Math.min(i - tuple[1] + 1, minLength);
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 1 : minLength;
    }

    public static void execute(int[] nums, int exp) {
        int o = new DegreeOfArray().findShortestSubArray(nums);
        System.out.println(o);
        System.out.println(o == exp);
    }

    public static void main(String[] args) {
        execute(new int[]{2, 2, 2}, 3);
        execute(new int[]{2, 1}, 1);
        execute(new int[]{1, 1}, 2);
        execute(new int[]{1, 2, 2, 3, 1, 4, 2}, 6);
        execute(new int[]{1,2,2,3,1}, 2);
        execute(new int[]{1}, 1);
        execute(new int[]{1,2,3,2,4,2,5,5,5}, 3);
    }


    static class HitCounter {

        private final Map<Integer, Integer> counter;

        /** Initialize your data structure here. */
        public HitCounter() {
            this.counter = new ConcurrentHashMap<>();
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            counter.put(timestamp, counter.getOrDefault(timestamp, 0) + 1);
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            return counter.getOrDefault(timestamp, 0);
        }
    }
}
