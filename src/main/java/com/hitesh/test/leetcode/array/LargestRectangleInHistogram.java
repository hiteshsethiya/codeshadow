package com.hitesh.test.leetcode.array;

import java.util.Stack;

public class LargestRectangleInHistogram {

    /*
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
     *
     * https://assets.leetcode.com/uploads/2018/10/12/histogram.png
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     *
     * https://assets.leetcode.com/uploads/2018/10/12/histogram_area.png
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     *
     * Example:
     *
     * Input: [2,1,5,6,2,3]
     * Output: 10
     */

    public boolean isEmpty(int[] a) {
        return a == null || a.length == 0;
    }

    public int largestRectangleArea(int[] heights) {
        if(isEmpty(heights)) {
            return 0;
        }
        int area, maxArea = 0, i = 0, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        while(i < n) {
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                ++i;
            } else {
                int currentMaxHeightIdx = stack.pop();
                if(stack.isEmpty()) {
                    area = heights[currentMaxHeightIdx] * i; // since i is ZERO based we need not subtract -1
                } else {
                    area = heights[currentMaxHeightIdx] * (i - stack.peek() - 1); // -1 cause ith height isn't included
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while(!stack.isEmpty()) {
            int currentMaxHeightIdx = stack.pop();
            if(stack.isEmpty()) {
                area = heights[currentMaxHeightIdx] * i; // since i is ZERO based we need not subtract -1
            } else {
                area = heights[currentMaxHeightIdx] * (i - stack.peek() - 1); // -1 cause ith height isn't included
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

    }

}
