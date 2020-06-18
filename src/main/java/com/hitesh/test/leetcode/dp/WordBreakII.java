package com.hitesh.test.leetcode.dp;

import java.util.*;

public class WordBreakII {

    /*
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
     *
     * Note:
     *
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     *
     * Input:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     * Output:
     * [
     *   "cats and dog",
     *   "cat sand dog"
     * ]
     * Example 2:
     *
     * Input:
     * s = "pineapplepenapple"
     * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
     * Output:
     * [
     *   "pine apple pen apple",
     *   "pineapple pen apple",
     *   "pine applepen apple"
     * ]
     * Explanation: Note that you are allowed to reuse a dictionary word.
     * Example 3:
     *
     * Input:
     * s = "catsandog"
     * wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output:
     * []
     */

    public boolean isValid(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); ++i) {
            for(int j = 0; j < i; ++j) {
                if(dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> possibleStrings = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        if(!isValid(s, dict)) {
            return possibleStrings;
        }
        wordBreakStrings(s, dict, 0, new StringBuilder(), possibleStrings);
        return possibleStrings;
    }

    public void wordBreakStrings(String s, Set<String> dict, int index, StringBuilder sb, List<String> output) {
        if(index == s.length()) {
            sb.deleteCharAt(sb.length() - 1);
            output.add(sb.toString());
            return;
        }
        for(int i = index; i < s.length(); ++i) {
            String word = s.substring(index, i + 1);
            if(dict.contains(word)) {
                int length = sb.length();
                sb.append(word).append(" ");
                wordBreakStrings(s, dict, i + 1, sb, output);
                sb.setLength(length);
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(new WordBreakII().wordBreak(s, dict));
        s = "pineapplepenapple";
        dict = Arrays.asList("apple","pen","applepen","pine","pineapple");
        System.out.println(new WordBreakII().wordBreak(s, dict));
    }
}
