package com.hitesh.test.leetcode.number;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ArithmeticSubarrays {

    public boolean isValidSeq(int[] nums, int l, int r) {
        if(r - l < 1) return false;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = l ; i <= r; ++i) {
            heap.offer(nums[i]);
        }
        int a = heap.poll(), prev = heap.poll();
        int d = prev - a;
        while(!heap.isEmpty()) {
            int curr = heap.poll();
            if(curr - prev != d) return false;
            prev = curr;
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        if(l == null || l.length == 0) return new ArrayList<>();
        List<Boolean> o = new ArrayList<>();
        for(int i = 0; i < l.length; ++i) {
            o.add(isValidSeq(nums, l[i], r[i]));
        }
        return o;
    }
}
