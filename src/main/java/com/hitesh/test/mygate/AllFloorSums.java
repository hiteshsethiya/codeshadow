package com.hitesh.test.mygate;

import java.util.*;

public class AllFloorSums {
    static final int mod = 1000003;
    final static int MX = 100005;
    static int solveIt(int[] nums) {
        int[] cnt = new int[MX];
        int[] b = new int[MX];
        for (int num : nums) {
            cnt[num]++;
        }
        b[MX - 1] = cnt[MX - 1];
        for (int i = MX - 2; i >= 1; i--) {
            b[i] = b[i + 1] + cnt[i];
        }
        long res = 0;
        for (int i = 1; i < MX; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            for (int j = i, mul = 1; j < MX; j += i, mul++) {
                /// there are b[j] - b[j + i] elements which adds mul to the ans
                res += (long) (b[j] - b[Math.min(MX - 1, j + i)]) * mul * cnt[i]; /// *cnt[i] because we have cnt[i] times i
            }
        }
        return (int) (res % mod);
    }

    public static int[] sumZero(int n) {
        int[] a = new int[n];
        if(n <= 1) return a;
        if((n & 1) > 0) {
            a[n/2] = 0;
        }
        for(int i = 0; i < n / 2; ++i) {
            a[i] = (i + 1);
            a[n - i - 1] = -(i+1);
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(5 + " -> " + Arrays.toString(sumZero(5)));
        System.out.println(4 + " -> " + Arrays.toString(sumZero(4)));
        System.out.println(1 + " -> " + Arrays.toString(sumZero(1)));
        System.out.println(3 + " -> " + Arrays.toString(sumZero(3)));
        System.out.println(2 + " -> " + Arrays.toString(sumZero(2)));
//        System.out.println(solveIt(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(solveIt(new int[]{5, 4, 3, 2, 1}));
//        System.out.println(solveIt(new int[]{5, 5, 3, 2, 1}));
    }
}
