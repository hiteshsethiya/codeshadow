package com.hitesh.test.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int n = s.length(), maxLen = 1;
        Map<Character, Integer> windowCharacters = new HashMap<>();
        windowCharacters.put(s.charAt(0), 0);
        for (int i = 0, j = 1; j < n; ++j) {
            if (windowCharacters.containsKey(s.charAt(j))) {
                int k = windowCharacters.get(s.charAt(j));
                while (i <= k) {
                    windowCharacters.remove(s.charAt(i++));
                }
            }
            windowCharacters.put(s.charAt(j), j);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcdaaaa"));
    }

}
