package com.hitesh.test.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargestElementInAnArray {

    static public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k < 0) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(nums.length, (x, y) -> y - x);
        q.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for (int i = 0; i < k - 1; ++i) q.poll();
        return q.peek();
    }

    // Better runtime.
    public int findKthLargestSoln(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k < 0) return 0;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 8, 2};
        System.out.println(Arrays.toString(a) + " -> " + findKthLargest(a, 3));
        a = new int[]{3,2,1,5,6,4};
        System.out.println(Arrays.toString(a) + " -> " + findKthLargest(a, 2));
        a = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(Arrays.toString(a) + " -> " + findKthLargest(a, 4));
    }

}
