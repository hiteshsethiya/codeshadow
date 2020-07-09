package com.hitesh.test.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return 0;
        int n = s.length(), maxLen = 1;
        Map<Character, Integer> windowCharacters = new HashMap<>();
        for (int i = 0, j = 0; j < n; ++j) {
            if (windowCharacters.size() == k && !windowCharacters.containsKey(s.charAt(j))) {
                while (windowCharacters.size() >= k) {
                    windowCharacters.put(s.charAt(i), windowCharacters.getOrDefault(s.charAt(i), 0) - 1);
                    if (windowCharacters.get(s.charAt(i)) == 0) windowCharacters.remove(s.charAt(i));
                    ++i;
                }
            }
            windowCharacters.put(s.charAt(j), windowCharacters.getOrDefault(s.charAt(j), 0) + 1);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public static void execute(String s, int k, int exp) {
        int o = new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(o);
        System.out.println(o == exp);
    }

    public static void main(String[] args) {
        execute("abaccc", 2, 4);
        execute("", 0, 0);
        execute("asdf", 0, 0);
        execute("abcdeafhhhfhhhhgh", 3, 11);
        execute("zfeeefz", 1, 3);
        execute("zfeeefz", 2, 5);
        execute("zfeeefz", 3, 7);
        execute("abcddcba", 1, 2);
        execute("abcddcba", 2, 4);
        execute("abcddcba", 3, 6);
        execute("abcddcba", 4, 8);
        execute("eceba", 1, 1);
        execute("eceba", 2, 3);
        execute("eceba", 3, 4);
        execute("eceba", 4, 5);
        execute("aa", 1, 2);
        execute("aa", 2, 2);
    }

}
