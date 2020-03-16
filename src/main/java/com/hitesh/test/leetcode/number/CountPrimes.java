package com.hitesh.test.leetcode.number;

public class CountPrimes {

    /*
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * Example:
     *
     * Input: 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     */

    static public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] b = new boolean[n];
        b[0] = true;
        b[1] = true;
        for (int i = 2; i * i < n; ++i) {
            if (!b[i]) {
                for (int j = i * i; j < n; j += i) {
                    b[j] = true;
                }
            }
        }

        int c = 0;
        for (boolean i : b) {
            if (!i) c++;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(4));
        System.out.println(countPrimes(5));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(50));
        System.out.println(countPrimes(499979));
    }

}

       