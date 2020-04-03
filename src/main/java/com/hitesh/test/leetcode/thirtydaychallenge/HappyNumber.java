package com.hitesh.test.leetcode.thirtydaychallenge;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /*
     * Write an algorithm to determine if a number is "happy".
     *
     * A happy number is a number defined by the following process: Starting with any positive integer,
     * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
     * (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy numbers.
     *
     * Example:
     *
     * Input: 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */

    static public boolean isHappy(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        Set<Long> computes = new HashSet<>();
        for(long i = n; i > 0;) {
            long iN = 0;
            while(i > 0) {
                iN += (i%10) * (i%10);
                i /= 10;
            }
            if(iN == 1) return true;
            if(computes.contains(iN)) return false;
            computes.add(iN);
            i = iN;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(5));
        System.out.println(isHappy(1));
        System.out.println(isHappy(Integer.MAX_VALUE));
    }

}
