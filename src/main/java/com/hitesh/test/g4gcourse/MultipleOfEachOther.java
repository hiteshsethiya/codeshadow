package com.hitesh.test.g4gcourse;

public class MultipleOfEachOther {


    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }

    public static boolean isMultipleOfEachOther(int a, int b) {
        return gcd(a,b) != 1;
    }

    public static void main(String[] args) {
        System.out.println(isMultipleOfEachOther(2, 5));
    }

}
