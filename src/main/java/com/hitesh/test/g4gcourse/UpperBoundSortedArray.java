package com.hitesh.test.g4gcourse;

public class UpperBoundSortedArray {

    /**
     * Handles repeats too
     * @param a
     * @param x
     * @return
     */
    public static int upperBound(int[] a, int x) {

        if(a[a.length - 1] < x) return -1;
        if(a[0] > x) return 0;

        for(int l = 0, r = a.length -1; l <= r; ) {
            int m = l + (r - l) / 2;
            if(a[m] == x) {
                while(a[m] == x) {
                    ++m;
                }
                return m;
            }
            if(a[m] > x) {
                if(m > 0 && a[m - 1] < x) {
                    return m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 10, 10, 10, 12, 15};
        System.out.println(upperBound(a, 0));
        System.out.println(upperBound(a, 1));
        System.out.println(upperBound(a, 3));
        System.out.println(upperBound(a, 5));
        System.out.println(upperBound(a, 10));
    }
/*
    public static void main(String[] args) {
        System.out.println("asdf".hashCode());
        System.out.println("dfas".hashCode());
    }*/

}
