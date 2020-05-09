package com.hitesh.test.leetcode.string;

import java.util.*;

public class WordLadder {

    /*
     * Given two words (beginWord and endWord), and a dictionary's word list,
     * find the length of shortest transformation sequence from beginWord to endWord, such that:
     *
     *     Only one letter can be changed at a time.
     *     Each transformed word must exist in the word list.
     *
     * Note:
     *
     *     Return 0 if there is no such transformation sequence.
     *     All words have the same length.
     *     All words contain only lowercase alphabetic characters.
     *     You may assume no duplicates in the word list.
     *     You may assume beginWord and endWord are non-empty and are not the same.
     *
     * Example 1:
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     *
     * Example 2:
     *
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * Output: 0
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */

    static class Pair<K,V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private int L;
    private Map<String, List<String>> genericTransforms;

    public WordLadder() {
        this.genericTransforms = new HashMap<>();
    }

    public int oneBfs(Queue<Pair<String,Integer>> q,
                   Map<String, Integer> visited,
                   Map<String, Integer> otherVisited) {
        if(q.isEmpty()) return -1;
        Pair<String, Integer> adjacentNode = q.poll();
        String word = adjacentNode.getKey();
        int level = adjacentNode.getValue();
        for(int i = 0; i < L; ++i) {
            StringBuilder wordSb = new StringBuilder(word);
            String iTransform = wordSb.replace(i, i + 1, "*").toString();

            for(String adjacentWord : this.genericTransforms.getOrDefault(iTransform, new ArrayList<>())) {
                if(otherVisited.containsKey(adjacentWord)) {
                    return level + otherVisited.get(adjacentWord);
                }
                if(!visited.containsKey(adjacentWord)) {
                    visited.put(adjacentWord, level + 1);
                    q.add(new Pair<>(adjacentWord, level + 1));
                }
            }
        }

        return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.isEmpty()) return 0;

        if (!wordList.contains(endWord)) {
            return 0;
        }
        L = beginWord.length();
        wordList.forEach(iWord -> {
            for(int i = 0; i < L; ++i) {
                StringBuilder word = new StringBuilder(iWord);
                String iTransform = word.replace(i, i + 1, "*").toString();
                List<String> transformations = genericTransforms.getOrDefault(iTransform, new ArrayList<>());
                transformations.add(iWord);
                genericTransforms.put(iTransform, transformations);
            }
        });

        Queue<Pair<String,Integer>> beginQ = new LinkedList<>();
        Queue<Pair<String,Integer>> endQ = new LinkedList<>();
        beginQ.add(new Pair<>(beginWord, 1));
        endQ.add(new Pair<>(endWord, 1));

        Map<String, Integer> beginVisited = new HashMap<>();
        beginVisited.put(beginWord, 1);
        Map<String, Integer> endVisited = new HashMap<>();
        endVisited.put(endWord, 1);

        while(!beginQ.isEmpty() && !endQ.isEmpty()) {
            int ans = oneBfs(beginQ, beginVisited, endVisited);
            if(ans > -1) return ans;
            ans = oneBfs(endQ, endVisited, beginVisited);
            if(ans > -1) return ans;
        }

        return 0;
    }

    public static void execute(String beginWord, String endWord, String[] wordListArr, int exp) {
        System.out.println("BeginWord : " + beginWord + " endWord : " + endWord);
        System.out.println("word List : " + Arrays.toString(wordListArr));
        int ans = new WordLadder().ladderLength(beginWord, endWord, Arrays.asList(wordListArr));
        System.out.println("ans : " + ans);
        System.out.println(ans == exp);
    }

    public static void main(String[] args) {
        execute("hit", "cog", new String[]{"hot","dot","dog","lot","log","cog"}, 5);
    }

}
