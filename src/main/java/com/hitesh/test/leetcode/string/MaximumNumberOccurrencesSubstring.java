package com.hitesh.test.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOccurrencesSubstring {

    public void generateSubStrings(String s, int i, int maxLetters, int minSize,
                                   int maxSize, Map<String, Integer> subStrings) {
        StringBuilder sb = new StringBuilder();
        Set<Character> charFreq = new HashSet<>();
        for (; i < s.length(); ++i) {
            charFreq.add(s.charAt(i));
            sb.append(s.charAt(i));
            if (charFreq.size() > maxLetters || sb.length() > maxSize) break;
            if (sb.length() >= minSize) {
                String sub = sb.toString();
                subStrings.put(sub, subStrings.getOrDefault(sub, 0) + 1);
            }
        }
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.isEmpty() || minSize > s.length()) return 0;
        Map<String, Integer> subStrings = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            generateSubStrings(s, i, maxLetters, minSize, maxSize, subStrings);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : subStrings.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }

    public static void execute(String s, int maxLetters, int minSize, int maxSize, int exp) {
        int o = new MaximumNumberOccurrencesSubstring().maxFreq(
                s, maxLetters, minSize, maxSize
        );
        System.out.println(o);
        System.out.println(o == exp);
    }

    public static void main(String[] arg) {
        execute("aababcaab", 2, 3, 4, 2);
        execute("aaaa", 1, 3, 3, 2);
        execute("aaaa", 1, 1, 1, 4);
        execute("aabcabcab", 2, 2, 3, 3);
        execute("abcde", 2, 3, 3, 0);
    }

}
