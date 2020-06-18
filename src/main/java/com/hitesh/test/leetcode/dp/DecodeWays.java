package com.hitesh.test.leetcode.dp;

public class DecodeWays {

    /*
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     *
     * Example 1:
     *
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     * Example 2:
     *
     * Input: "226"
     * Output: 3
     * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     */

    // T & S: O(N)
    public int numDecodings(String s) {
        if(s == null || s.isEmpty() || s.startsWith("0")) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); ++i) {
            int digits = Integer.parseInt(s.substring(i - 2, i));
            int digit = Integer.parseInt(s.substring(i - 1, i));
            dp[i] = ((0 < digit && digit <= 9) ? dp[i - 1] : 0)
                    + ((9 < digits && digits <= 26) ? dp[i - 2] : 0);
        }
        return dp[s.length()];
    }
}
