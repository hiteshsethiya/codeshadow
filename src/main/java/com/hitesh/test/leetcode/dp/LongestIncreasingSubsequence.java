package com.hitesh.test.leetcode.dp;

public class LongestIncreasingSubsequence {

    public static int cielIdx(int[] a, int l, int r, int x) {
        while(r > l) {
            int m = l + (r - l) / 2;
            if(a[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    static public int lengthOfLIS(int[] a) {
        if(a == null || a.length == 0) return 0;
        int n = a.length, len = 1;
        int[] tail = new int[a.length];
        tail[0] = a[0];
        for(int i = 1; i < n; ++i) {
            if(tail[len - 1] < a[i]) {
                tail[len] = a[i]; len++;
            } else {
                int c = cielIdx(tail, 0, len - 1, a[i]);
                tail[c] = a[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        /*int[] a = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(a));
        a = new int[] {};
        System.out.println(lengthOfLIS(a));
        a = new int[] {8, 100, 150, 10, 12, 14, 110};
        System.out.println(lengthOfLIS(a));*/
    }
}
