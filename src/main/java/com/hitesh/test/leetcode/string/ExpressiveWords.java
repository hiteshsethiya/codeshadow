package com.hitesh.test.leetcode.string;

public class ExpressiveWords {

    /**
     * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".
     * In these strings like "heeellooo", we have groups of adjacent
     * letters that are all the same:  "h", "eee", "ll", "ooo".
     * <p>
     * For some given string S, a query word is stretchy if it can be made to be equal to S
     * by any number of applications of the following extension operation: choose a group consisting of characters c,
     * and add some number of characters c to the group so that the size of the group is 3 or more.
     * <p>
     * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo",
     * but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension
     * like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be
     * stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.
     * <p>
     * Given a list of query words, return the number of words that are stretchy.
     * <p>
     * <p>
     * <p>
     * Example:
     * Input:
     * S = "heeellooo"
     * words = ["hello", "hi", "helo"]
     * Output: 1
     * Explanation:
     * We can extend "e" and "o" in the word "hello" to get "heeellooo".
     * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
     * <p>
     * <p>
     * Notes:
     * <p>
     * 0 <= len(S) <= 100.
     * 0 <= len(words) <= 100.
     * 0 <= len(words[i]) <= 100.
     * S and all words in words consist only of lowercase letters
     */

    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(S, word)) {
                count++;
            }
        }
        return count;
    }

    public boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            int sLength = getRepeatedLength(s, i);
            int wLength = getRepeatedLength(word, j);
            if (sLength < 3 && sLength != wLength || sLength >= 3 && sLength < wLength) {
                return false;
            }
            i += sLength;
            j += wLength;
        }
        return i == s.length() && j == word.length();
    }

    public int getRepeatedLength(String s, int i) {
        int j = i + 1;
        for (; j < s.length() && s.charAt(i) == s.charAt(j); ++j) ;
        return j - i;
    }

    public static void execute(String S, String[] words, int ans) {
        int o = new ExpressiveWords().expressiveWords(S, words);
        System.out.println(o);
        System.out.println(o == ans);
    }

    public static void main(String[] args) {
        String[] words = {"hello", "hi", "helo", "hlo", "heeellooo"};
        String s = "heeellooo";
        execute(s, words, 2);
        words = new String[]{"abc"};
        s = "abcd";
        execute(s, words, 0);
    }

}
