package com.hitesh.test.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public boolean isOverLapping(int[] first, int[] second) {
        return first[0] <= second[0] && second[0] <= first[1];
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> output = new ArrayList<>();
        int[] prevInterval = intervals[0];
        for (int i = 1; i < n; ++i) {
            int[] currentInterval = intervals[i];
            if (isOverLapping(prevInterval, currentInterval)) {
                prevInterval[1] = Math.max(prevInterval[1], currentInterval[1]);
            } else {
                output.add(prevInterval);
                prevInterval = currentInterval;
            }
        }
        if (output.isEmpty() || output.get(output.size() - 1) != prevInterval) {
            output.add(prevInterval);
        }
        int[][] mergedIntervals = new int[output.size()][2];
        for (int i = 0; i < output.size(); ++i) {
            mergedIntervals[i][0] = output.get(i)[0];
            mergedIntervals[i][1] = output.get(i)[1];
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        int[][] interval = new int[][]{{1,4},{0,4}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(interval)));
        interval = new int[][]{{1,4},{2,3}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(interval)));

        interval = new int[][]{{1,4},{2,3}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(interval)));
    }

}
