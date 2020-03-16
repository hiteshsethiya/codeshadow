package com.hitesh.test.g4gcourse.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuyAndSell {

    static void stockBuySell(int[] price, int n) {

        List<Tuple> trades = new ArrayList<>();
        Tuple iTrade = new Tuple();
        iTrade.buy = 0;
        int currProfit = 0;
        for(int i = 1; i < n; ++i) {

            if(price[i] - price[i-1] > 0) {
                currProfit += price[i] - price[i-1];
                iTrade.currProfit = currProfit;
                iTrade.sell = i;
            } else if(iTrade.currProfit > 0) {
                trades.add(iTrade);
                iTrade = new Tuple();
                iTrade.buy = i;
                currProfit = 0;
            } else {
                iTrade.buy = i;
            }
        }

        if(iTrade.sell != 0) {
            trades.add(iTrade);
        }

        if(trades.isEmpty()) {
            System.out.println("No Profit");
        } else {
            for (int j = 0; j < trades.size(); j++) {
                Tuple i = trades.get(j);
                System.out.print("(" + i.buy + " " + i.sell + ") ");
            }
        }
    }

    public static void main(String[] args) {
////        int[] a = {100,180, 260, 310, 40, 535, 695};
//        int[] a = {6764,3645,5181,5893,4542,6753,3996,5483,585,9895,2657,777,1343,4605,261,2225,959,9884,563,4131,6687,7528,6224,436,3333,110,2037,7007,4710,2310,7596,7827,2307,9129,72,3202,2234,4069,5037,2819,3964,7694,9948,5307,8652,6561,7532,9611,6445,8095,94,9484,1975,6319,9920,5308,6429,1958,8668,7491,620,6264,5318,2927,1745,5391,6129,3979,5812,1167,3150,9776,8861,3098,5083,3865,9659,8968,3476,6104,3415,9923,1940,1743,6242,1861,3403,9023,3819};
//        stockBuySell(a, a.length);
//        System.out.println();
//        a = new int[]{23,13, 25, 29, 33, 19, 34, 45, 65, 67};
//        stockBuySell(a, a.length);
//        System.out.println();
//        a = new int[]{4, 2, 2, 2, 4};
//        stockBuySell(a, a.length);
//        System.out.println();
//        a = new int[]{1, 2, 3, 4};
//        stockBuySell(a, a.length);
//        System.out.println();
//        a = new int[]{4, 3, 2, 1};
//        stockBuySell(a, a.length);
        Integer[] a = {1, 1, 1, 1};
        System.out.println(calculateTotalRegion(Arrays.asList(a)));
        a = new Integer[]{1234567890, 1234567890, 1234567890, 1234567890, 1234567890, 1234567890, 1234567890};
        System.out.println(calculateTotalRegion(Arrays.asList(a)));
        a = new Integer[]{1, 2, 1};
        System.out.println(calculateTotalRegion(Arrays.asList(a)));
        a = new Integer[]{1, 2, 3};
        System.out.println(calculateTotalRegion(Arrays.asList(a)));
        a = new Integer[]{3, 2, 1};
        System.out.println(calculateTotalRegion(Arrays.asList(a)));
    }

    public static long calculateTotalRegion(List<Integer> heights) {
        // Write your code here
        if(heights == null || heights.isEmpty()) return 0;
        if(heights.size() == 1) return 1;

        Long[] lMax = new Long[heights.size()];
        Long[] rMax = new Long[heights.size()];
        lMax[0] = Long.valueOf(heights.get(0));
        rMax[heights.size() - 1] = Long.valueOf(heights.get(heights.size() - 1));
        for(int i = 1; i < heights.size(); ++i) {
            lMax[i] = Math.min(lMax[i - 1], heights.get(i));
        }

        for(int i = heights.size() - 2; i >= 0; --i) {
            rMax[i] = Math.min(rMax[i + 1], heights.get(i));
        }

        long region = 0L;
        for(int i = 0; i < heights.size(); ++i) {
            region++;
            if(i > 0 && heights.get(i) >= lMax[i - 1]) {
                region += i;
            }
            if(i < heights.size() - 1 && heights.get(i) >= rMax[i + 1]) {
                region += heights.size() - i - 1;
            }
        }
        return region;
    }

    static class Tuple {
        private int buy;
        private int sell;
        private int currProfit;
    }

}


