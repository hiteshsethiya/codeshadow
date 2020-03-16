package com.hitesh.test.g4gcourse;

public class ReverseNumber {

    public static long reverseNumber(long n) {
        long r = 0L;
        while(n > 0) {
            r *= 10;
            r += n % 10;
            n /= 10;
        }
        return r;
    }

    public static long countDigits(long n) {
        long c = 0L;
        while(n > 0) {
            c++;
            n /= 10;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(987));
        System.out.println(countDigits(1));
        System.out.println(countDigits(3456));
    }
}
