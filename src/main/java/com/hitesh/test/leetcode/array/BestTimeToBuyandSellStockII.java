package com.hitesh.test.leetcode.array;

public class BestTimeToBuyandSellStockII {

    static int maxProfit(int[] prices) {
        int currProfit = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] - prices[i-1] > 0) {
                currProfit += prices[i] - prices[i-1];
            }
        }
        return currProfit;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2000, 1000, 3000, 400};
        System.out.println(maxProfit(a));
        a = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(a));
        a = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(a));
        a = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(a));
        a = new int[]{};
        System.out.println(maxProfit(a));
    }

}
