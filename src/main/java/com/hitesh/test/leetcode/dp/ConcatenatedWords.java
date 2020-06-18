package com.hitesh.test.leetcode.dp;

import com.hitesh.test.ListUtil;

import java.util.*;

public class ConcatenatedWords {

    public boolean isConcatenated(String s, Set<String> dictionary) {
        if (dictionary.isEmpty()) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> concatenatedWords = new ArrayList<>();
        Set<String> preDict = new HashSet<>();
        for (String word : words) {
            if (isConcatenated(word, preDict)) {
                concatenatedWords.add(word);
            }
            preDict.add(word);
        }
        return concatenatedWords;
    }


    public static void execute(String[] words, String[] ans) {
        List<String> result = new ConcatenatedWords().findAllConcatenatedWordsInADict(words);
        List<String> ansList = Arrays.asList(ans);
        System.out.println(result);
        System.out.println(ListUtil.isEqual(ansList, result));
        System.out.println();
    }

    public static void main(String[] args) {
        execute(new String[]{"a", "b", "ab", "abc"},
                new String[]{"ab"});

        execute(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatsdogcats"},
                new String[]{"catsdogcats", "dogcatsdog", "ratcatsdogcats"});
    }

}
