package com.hitesh.test.leetcode.array;

import java.util.Arrays;

public class BestTimetoBuyandSellStock {

    /*
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction
     * (i.e., buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */

    static public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int[] rMax = new int[prices.length];
        rMax[prices.length - 1] = prices[prices.length - 1];
        for(int j = prices.length - 2; j >= 0; --j) {
            rMax[j] = Math.max(prices[j], rMax[j + 1]);
        }
        int profit = 0;
        for(int i = 0; i < prices.length; ++i) {
            profit = Math.max(profit, rMax[i] - prices[i]);
        }
        return profit;
    }

    public static void execute(int[] prices, int exp) {
        long startTime = System.currentTimeMillis();
        int c = maxProfit(prices);
        System.out.println("Input : " + Arrays.toString(prices));
        System.out.println(c);
        System.out.println(c == exp);
        System.out.println(((System.currentTimeMillis() - startTime) / 1000) + "s");
    }

    public static void main(String[] args) {
        int p[] = new int[]{7,1,5,3,6,4};
        execute(p, 5);
        p = new int[]{7,6,4,3,1};
        execute(p, 0);
    }

}
