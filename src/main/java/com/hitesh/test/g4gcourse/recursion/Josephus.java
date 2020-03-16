package com.hitesh.test.g4gcourse.recursion;

public class Josephus {

    /**
     * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction.​
     * The task is to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle, you are the last one remaining and survive.
     */

    // returns the last guy standing.
    public static int allKills(int n, int k) {
        if (n == 1) return 0;
        return (allKills(n - 1, k) + k) % n;
    }

    public static int josephus(int n, int k) {
        return allKills(n, k) + 1;
    }

    public static void main(String[] args) {
//        System.out.println(allKills(7, 3));
        System.out.println(sumOfDigits(99999));
    }

    static int sum = 0;
    // complete the function
    public static int sumOfDigits(int n) {
        if(n == 0) return 0;
        sumOfDigits(n / 10);
        sum += n % 10;
        return sum;
    }

}
