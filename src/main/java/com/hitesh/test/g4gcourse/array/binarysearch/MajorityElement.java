package com.hitesh.test.g4gcourse.array.binarysearch;

public class MajorityElement {
    // An element that occurs more than n / 2 times

    public static int findCandidate(int[] a) {
        int count = 0, maxIndex = 1;
        for(int i = 1; i < a.length; ++i) {
            if(a[maxIndex] == a[i]) {
                ++count;
            } else {
                --count;
            }
            if(count == 0) {
                maxIndex = i;
                count = 1;
            }
        }
        return maxIndex;
    }

    public static int majorityElement(int[] a) {
        int majIndex = findCandidate(a);
        int count = 0;
        for (int value : a) {
            if (value == a[majIndex]) ++count;
        }
        return (count > a.length / 2) ? a[majIndex] : -1;
    }
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(majorityElement(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(majorityElement(new int[]{3,1, 3, 3, 2}));
    }
}
