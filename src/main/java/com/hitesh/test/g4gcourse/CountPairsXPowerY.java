package com.hitesh.test.g4gcourse;

import java.util.Arrays;

public class CountPairsXPowerY {

    public static int count(int x, int[] y, int[] countOfExceptions) {

        if (x == 0) return 0;
        if (x == 1) return countOfExceptions[0];

        int idx = UpperBoundSortedArray.upperBound(y, x); // handles repeats
        if (idx < 0) {
            return (countOfExceptions[0] + countOfExceptions[1]);
        }
        int count = (y.length - idx) + countOfExceptions[0] + countOfExceptions[1];
        if(x == 2) {
            count -= (countOfExceptions[3] + countOfExceptions[4]);
        }

        if(x == 3) {
            count += countOfExceptions[2];
        }
        return count;
    }

    public static int countPairs(int[] x, int[] y) {

        Arrays.sort(y);

        int[] countOfExceptions = new int[5];
        for (int i = 0; i < y.length; ++i) {
            if (y[i] < 5) {
                countOfExceptions[y[i]]++;
            } else {
                break;
            }
        }

        int count = 0;
        for (int i = 0; i < x.length; ++i) {
            count += count(x[i], y, countOfExceptions);
        }
        return count;
    }

    public static void main(String args[]) {
        int X[] = {5, 6, 7, 8};
        int Y[] = {0, 1, 2, 3, 4};

        System.out.println("Total pairs = " + countPairs(X, Y));
    }

}
