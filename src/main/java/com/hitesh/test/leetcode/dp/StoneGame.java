package com.hitesh.test.leetcode.dp;

public class StoneGame {
    /*
     * Alex and Lee play a game with piles of stones.
     * There are an even number of piles arranged in a row, and each pile has a positive
     * integer number of stones piles[i].
     *
     * The objective of the game is to end with the most stones.
     * The total number of stones is odd, so there are no ties.
     *
     * Alex and Lee take turns, with Alex starting first.
     * Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.
     * This continues until there are no more piles left, at which point the person with the most stones wins.
     *
     * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
     *
     * Example 1:
     *
     * Input: [5,3,4,5]
     * Output: true
     * Explanation:
     * Alex starts first, and can only take the first 5 or the last 5.
     * Say he takes the first 5, so that the row becomes [3, 4, 5].
     * If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
     * If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
     * This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
     *
     *
     * Note:
     *
     * 2 <= piles.length <= 500
     * piles.length is even.
     * 1 <= piles[i] <= 500
     * sum(piles) is odd.
     */

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        int sum = piles[0];
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = Math.max(piles[i], piles[i + 1]);
            sum += piles[i + 1];
        }
        for (int gap = 3; gap < n; gap += 2) {
            for (int i = 0; i + gap < n; ++i) {
                int j = i + gap;
                dp[i][j] = Math.max(
                        piles[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        piles[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2])
                );
            }
        }
        return dp[0][n - 1] >= (sum - dp[0][n - 1]);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 10, 4};
        System.out.println(new StoneGame().stoneGame(a));
        a = new int[]{3, 7, 2, 3};
        System.out.println(new StoneGame().stoneGame(a));
        a = new int[]{7, 8, 8, 10};
        System.out.println(new StoneGame().stoneGame(a));
    }
}
