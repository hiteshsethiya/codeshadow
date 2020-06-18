package com.hitesh.test.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InsertInterval {

    public boolean isInBound(int[] interval, int key) {
        return interval[0] <= key && key <= interval[1];
    }

    public void binarySearch(int[][] intervals, int key, AtomicInteger ans, AtomicInteger max, boolean towardsMin) {
        for (int l = 0, r = intervals.length - 1; l <= r; ) {
            int m = l + (r - l) / 2;
            if (isInBound(intervals[m], key)) {
                ans.set(m);
                max.set(Math.max(max.get(), intervals[m][1]));
                if (towardsMin) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (key > intervals[m][0]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }

    public int[][] insertBinarySearch(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int m = intervals.length;
        AtomicInteger startIndex = new AtomicInteger(-1);
        AtomicInteger max = new AtomicInteger(0);
        binarySearch(intervals, newInterval[0], startIndex, max, true);
        AtomicInteger endIndex = new AtomicInteger(-1);
        binarySearch(intervals, newInterval[1], endIndex, max, false);

        // start Index found but end not index found
        // start Index not found but end index found
        // start and end Indexes found

        int start = Math.max(0, startIndex.get());
        int end = Math.min(intervals.length - 1, Math.max(endIndex.get(), 0));

        // To create the list of new Intervals
        List<int[]> newIntervals = new ArrayList<>();

        for (int i = 0; i < start; ++i) {
            newIntervals.add(intervals[i]);
        }
        newInterval[0] = Math.min(newInterval[0], intervals[start][0]);
        newInterval[1] = Math.max(newInterval[1], Math.max(max.get(), intervals[end][1]));
        newIntervals.add(newInterval);
        for (int i = end + 1; i < intervals.length; ++i) {
            newIntervals.add(intervals[i]);
        }
        int[][] output = new int[newIntervals.size()][2];
        for (int i = 0; i < newIntervals.size(); ++i) {
            output[i] = newIntervals.get(i);
        }
        return output;
    }


    // Linear
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new LinkedList<>();
        int i = 0, m = intervals.length;
        int startTime = newInterval[0];
        int endTime = newInterval[1];
        while (i < m && intervals[i][1] < startTime) {
            newIntervals.add(intervals[i]);
            ++i;
        }
        while (i < m && intervals[i][0] <= endTime) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            ++i;
        }
        newIntervals.add(newInterval);
        while (i < m) {
            newIntervals.add(intervals[i]);
            ++i;
        }
        int[][] output = new int[newIntervals.size()][2];
        for (i = 0; i < newIntervals.size(); ++i) {
            output[i] = newIntervals.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {3, 5},
                {6, 9}
        };
        System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals, new int[]{1, 2})));
        intervals = new int[][]{
                {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}
        };
        System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals, new int[]{18, 20})));
    }

}
