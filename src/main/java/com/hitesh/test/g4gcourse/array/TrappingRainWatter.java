package com.hitesh.test.g4gcourse.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainWatter {

    public static int maxTrappedRainWater(int[] a) {
        if(a.length <= 1) return 0;
        int[] lMax = new int[a.length];
        lMax[0] = a[0];
        for(int i = 1; i < a.length; ++i) {
            lMax[i] = Math.max(lMax[i - 1], a[i]);
        }
        int[] rMax = new int[a.length];
        rMax[a.length - 1] = a[a.length - 1];
        for(int i = a.length - 2; i >= 0; --i) {
            rMax[i] = Math.max(rMax[i + 1], a[i]);
        }

        int res = 0;
        for(int i = 1; i < a.length - 1; ++i) {
            res += (Math.max(0, Math.min(rMax[i], lMax[i]) - a[i]));
        }
        return res;
    }

    public static int containerWithMostWater(int[] a) {
        if(a.length <= 1) return 0;
        int res = 0;
        for(int i = 0, j = a.length - 1; i < j;) {
            res = Math.max((j - i) * Math.min(a[i], a[j]), res);
            if(a[i] < a[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return res;
    }

    public static void main (String[] args) throws IOException {
//        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(b.readLine());
//        while (t-- > 0) {
//            int n = Integer.parseInt(b.readLine());
//            String[] input = b.readLine().split(" ");
//            int[] a = new int[n];
//            int j = 0;
//            for(String i : input) {
//                a[j++] = Integer.parseInt(i);
//            }
//            System.out.println(maxTrappedRainWater(a));
//        }

        System.out.println(maxTrappedRainWater(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(maxTrappedRainWater(new int[] {}));
        System.out.println(maxTrappedRainWater(new int[] {1}));
    }

}
