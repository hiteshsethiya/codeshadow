package com.hitesh.test.g4gpractice.array;

import java.util.Scanner;

public class SticklerThief {
    //https://practice.geeksforgeeks.org/problems/stickler-theif/0

    public static int maxLoot(int n, int[] cash) {

        int exclCurr = cash[0], inclCurr = 0, inclPrev = cash[0], exclPrev = 0;
        for(int i = 1; i < n; ++i) {
            exclCurr = Math.max(inclPrev, exclPrev);
            inclCurr = exclPrev + cash[i];
            exclPrev = exclCurr;
            inclPrev = inclCurr;
        }
        return Math.max(inclCurr, exclCurr);
    }


    public static void main (String[] args) {
        //code
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while(t-- > 0) {
                int n = scanner.nextInt(), i = 0;
                int[] a = new int[n];
                while (i < n) {
                    a[i++] = scanner.nextInt();
                }
                System.out.println(maxLoot(n, a));
            }
        }
    }
}
