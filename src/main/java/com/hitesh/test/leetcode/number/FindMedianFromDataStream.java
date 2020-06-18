package com.hitesh.test.leetcode.number;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    /*
     * Median is the middle value in an ordered integer list. If the size of the list is even,
     * there is no middle value. So the median is the mean of the two middle value.
     *
     * For example,
     * [2,3,4], the median is 3
     *
     * [2,3], the median is (2 + 3) / 2 = 2.5
     *
     * Design a data structure that supports the following two operations:
     *
     * void addNum(int num) - Add a integer number from the data stream to the data structure.
     * double findMedian() - Return the median of all elements so far.
     *
     *
     * Example:
     *
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     *
     *
     * Follow up:
     *
     * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
     * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
     */

    public static class MedianFinder {

        private PriorityQueue<Integer> leftMaxHeap; // points to the left side of the data stream
        private PriorityQueue<Integer> rightMinHeap; // points to the right side of the data stream
        private double median = 0.0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.leftMaxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            this.rightMinHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 3 cases
            if (this.leftMaxHeap.isEmpty()) {
                this.leftMaxHeap.offer(num);
                this.median = num * 1.0;
                return;
            }
            int signDiff = leftMaxHeap.size() - rightMinHeap.size();
            switch (signDiff) {
                case -1: {
                    // rightMinHeap has more elements
                    if(num < median) {
                        leftMaxHeap.offer(num);
                    } else {
                        leftMaxHeap.offer(rightMinHeap.poll());
                        rightMinHeap.offer(num);
                    }
                    median = (rightMinHeap.peek() + leftMaxHeap.peek()) / 2.0;
                } break;
                case 1: {
                    // leftMaxHeap has more elements
                    if(num < median) {
                        rightMinHeap.offer(leftMaxHeap.poll());
                        leftMaxHeap.offer(num);
                    } else {
                        rightMinHeap.offer(num);
                    }
                    median = (rightMinHeap.peek() + leftMaxHeap.peek()) / 2.0;
                } break;
                case 0: {
                    if(num < median) {
                        leftMaxHeap.offer(num);
                        median = leftMaxHeap.peek() * 1.0;
                    } else {
                        rightMinHeap.offer(num);
                        median = rightMinHeap.peek() * 1.0;
                    }
                } break;
            }
        }

        public double findMedian() {
            return median;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        System.out.println(mf.findMedian());
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(10);
        System.out.println(mf.findMedian());
        mf.addNum(15);
        System.out.println(mf.findMedian());
    }

}
