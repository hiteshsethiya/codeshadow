package com.hitesh.test.leetcode.search;

public class GuessNumberHigherOrLower {

    public static int guessNumber(int n) {
        if(guess(n) == 0) return n;
        int l = 0, r = n, guess;
        while(l <= r) {
            int m = l + (r - l) / 2;
            guess = guess(m);
            if(guess == 0) return m;
            else if(guess == -1) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static int guess(int n) {
        if(n == var) return 0;
        else if(n > var) return -1;
        else return 1;
    }
    public static int var = 1;
    public static void main(String[] args) {
        var = 6;
        System.out.println(guessNumber(10));
        var = 1;
        System.out.println(guessNumber(1));
        var = 2;
        System.out.println(guessNumber(2));
        var = 1;
        System.out.println(guessNumber(2));
    }
}
