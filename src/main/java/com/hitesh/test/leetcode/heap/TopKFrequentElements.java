package com.hitesh.test.leetcode.heap;

import java.util.*;

public class TopKFrequentElements {

    /*
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * Note:
     *
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
     * You can return the answer in any order.
     */


    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> eleFreq = new HashMap<>();
        Arrays.stream(nums).forEach(i -> eleFreq.put(i, eleFreq.getOrDefault(i, 0) + 1));
        PriorityQueue<Integer> heap = new PriorityQueue<>(eleFreq.size(), new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return eleFreq.getOrDefault(b, 0).compareTo(eleFreq.getOrDefault(a, 0));
            }
        });
        heap.addAll(eleFreq.keySet());
        int[] kMost = new int[k];
        for(int i = 0; i < k && !heap.isEmpty(); ++i) kMost[i] = heap.poll();
        return kMost;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,2,2,3};
        int k = 3;
        System.out.println(Arrays.toString(topKFrequent(a, k)));
        a = new int[]{1,1,1,2,2,3};
        k = 5;
        System.out.println(Arrays.toString(topKFrequent(a, k)));
        a = new int[]{1,2,3,4,5};
        k = 10;
        System.out.println(Arrays.toString(topKFrequent(a, k)));
    }
}
