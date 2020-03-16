package com.hitesh.test.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class KthLargestElementInAStream {

    /*
     * Design a class to find the kth largest element in a stream.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
     *
     * Example:
     * int k = 3;
     * int[] arr = [4,5,8,2];
     * KthLargest kthLargest = new KthLargest(3, arr);
     * kthLargest.add(3);   // returns 4
     * kthLargest.add(5);   // returns 5
     * kthLargest.add(10);  // returns 5
     * kthLargest.add(9);   // returns 8
     * kthLargest.add(4);   // returns 8
     *
     * Note:
     * You may assume that nums' length ≥ k-1 and k ≥ 1.
     */

    static class KthLargest {
        int k;
        PriorityQueue<Integer> q;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.q = new PriorityQueue<>(k); // min heap
            for(int i = 0; i < nums.length; ++i) {
                q.offer(nums[i]);
                if(q.size() == k + 1) {
                    q.poll();
                }
            }
        }

        public int add(int val) {
            q.offer(val);
            if(q.size() == k + 1) q.poll();
            return q.peek();
        }


        static public int insertAt(int[] a, int k, int l, int h) {
            if (a == null || a.length == 0) return 0;
            if (k <= a[0]) return 0;
            if (k > a[h]) return h + 1;
            if (k == a[h]) return h;
            while (l <= h) {
                int m = l + (h - l) / 2;
                if (a[m] == k) {
                    return m;
                }
                if (m == 0) return 0;
                if (a[m - 1] <= k && a[m] > k) {
                    return m;
                }
                if (a[m] > k) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return 0;
        }

        public static void main(String[] args) {
            /*int[] a = new int[]{1, 2, 3, 4, 5};
            System.out.println(Arrays.toString(a) + " -> " + KthLargest.insertAt(a, 3, 0, 3));
            System.out.println(Arrays.toString(a) + " -> " + KthLargest.insertAt(a, 6, 0, 3));
            System.out.println(Arrays.toString(a) + " -> " + KthLargest.insertAt(a, -1, 0, 3));*/

            int[] a = new int[]{4, 5, 8, 2};
            KthLargest kthLargest = new KthLargest(3, a);
            System.out.println(Arrays.toString(a) + " -> " + kthLargest.add(3)); // returns 4
            System.out.println(Arrays.toString(a) + " -> " + kthLargest.add(5)); // returns 5
            System.out.println(Arrays.toString(a) + " -> " + kthLargest.add(10)); // returns 5
            System.out.println(Arrays.toString(a) + " -> " + kthLargest.add(9)); // returns 8
            System.out.println(Arrays.toString(a) + " -> " + kthLargest.add(4)); // returns 8
        }
    }

}
