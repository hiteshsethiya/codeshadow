package com.hitesh.test.leetcode.string;

import java.util.*;

public class MostCommonWord {

    /*
     * Given a paragraph and a list of banned words, return the most frequent word
     * that is not in the list of banned words.
     * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
     *
     * Words in the list of banned words are given in lowercase, and free of punctuation.
     * Words in the paragraph are not case sensitive.  The answer is in lowercase.
     *
     *
     *
     * Example:
     *
     * Input:
     * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
     * banned = ["hit"]
     * Output: "ball"
     * Explanation:
     * "hit" occurs 3 times, but it is a banned word.
     * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
     * Note that words in the paragraph are not case sensitive,
     * that punctuation is ignored (even if adjacent to words, such as "ball,"),
     * and that "hit" isn't the answer even though it occurs more because it is banned.
     *
     *
     * Note:
     *
     * 1 <= paragraph.length <= 1000.
     * 0 <= banned.length <= 100.
     * 1 <= banned[i].length <= 10.
     * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
     * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
     * There are no hyphens or hyphenated words.
     * Words only consist of letters, never apostrophes or other punctuation symbols.
     */

    public static String getCleansedString(String str) {
        return str.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
    }

    public static boolean isEmpty(String a) {
        return a == null || a.trim().isEmpty();
    }

    static public String mostCommonWord(String paragraph, String[] banned) {
        if(isEmpty(paragraph) || banned == null) return "";
        paragraph = getCleansedString(paragraph);
        String[] words = paragraph.split(" ");
        Set<String> bannedHashes = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> freq = new HashMap<>();
        String maxString = null;
        int maxF = 0;
        for(String i : words) {
            i = i.trim();
            if(!isEmpty(i) && !bannedHashes.contains(i)) {
                freq.put(i, freq.getOrDefault(i, 0) + 1);
                if(maxF < freq.get(i)) {
                    maxF = freq.get(i);
                    maxString = i;
                }
            }
        }
        return maxString;
    }

    public static void execute(String p, String[] b, String exp) {
        String ans = mostCommonWord(p, b);
        System.out.println(p);
        System.out.println(Arrays.toString(b));
        System.out.println(ans);
        System.out.println(ans.equals(exp));
    }

    public static void main(String[] args) {
        String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] b = new String[]{"hit"};
        execute(p, b, "ball");
        p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        b = new String[]{};
        execute(p, b, "hit");
        p = "a, a, a, a, b,b,b,c, c";
        b = new String[]{"a"};
        execute(p, b, "b");
    }
}
