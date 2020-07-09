package com.hitesh.test.leetcode.string;

public class VerifyingAnAlienDictionary {

    /**
     * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
     * The order of the alphabet is some permutation of lowercase letters.
     * <p>
     * Given a sequence of words written in the alien language, and the order of the alphabet,
     * return true if and only if the given words are sorted lexicographicaly in this alien language.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
     * Output: true
     * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
     * Example 2:
     * <p>
     * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
     * Output: false
     * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
     * Example 3:
     * <p>
     * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
     * Output: false
     * Explanation: The first three characters "app" match, and the second string is shorter (in size.)
     * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank
     * character which is less than any other character (More info).
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 20
     * order.length == 26
     * All characters in words[i] and order are English lowercase letters.
     */

    public boolean isAlienSorted(String[] words, String order) {
        int[] alphas = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            alphas[order.charAt(i) - 'a'] = i + 1;
        }
        for (int j = 1; j < words.length; ++j) {
            String a = words[j - 1];
            String b = words[j];
            int n = Math.max(a.length(), b.length());
            for (int i = 0; i < n; ++i) {
                int aIdx = i < a.length() ? alphas[a.charAt(i) - 'a'] : 0;
                int bIdx = i < b.length() ? alphas[b.charAt(i) - 'a'] : 0;
                if (aIdx < bIdx) break;
                if (aIdx > bIdx) return false;
            }
        }
        return true;
    }

    public static void execute(String[] words, String order, boolean exp) {
        boolean o = new VerifyingAnAlienDictionary().isAlienSorted(words, order);
        System.out.println(o == exp);
    }

    public static void main(String[] args) {
        execute(new String[]{"aa","a"}, "abqwertyuioplkjhgfdszxcvnm", false);
        execute(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false);
        execute(new String[]{"apple", "azz"}, "abcdefghijklmnopqrstuvwxyz", true);
        execute(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false);
        execute(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true);
    }

}
