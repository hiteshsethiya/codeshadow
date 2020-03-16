package com.hitesh.test.g4gcourse.array.binarysearch;

public class Sqrt {

    static long sqrt(long x) {
        if(x == 0 || x == 1) return x;
        long ans = 1;
        for(long l = 1, h = x; l <= h; ) {
            long m = (l + h) / 2;
            if(m * m == x) {
                return m;
            } else if(m * m < x) {
                l = m + 1;
                ans = m;
            } else {
                h = m - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(sqrt(5));
        System.out.println(sqrt(9));
        System.out.println(sqrt(12));
    }


}
