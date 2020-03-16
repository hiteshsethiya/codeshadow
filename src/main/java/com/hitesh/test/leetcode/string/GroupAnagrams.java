package com.hitesh.test.leetcode.string;

import java.util.*;

public class GroupAnagrams {

    /*
     * Given an array of strings, group anagrams together.
     *
     * Example:
     *
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * Note:
     *
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     *
     * Case Failed:
     * Input ["cab","tin","pew","duh","may","ill","buy","bar","max","doc"]
     * Output [["buy"],["duh","ill"],["bar"],["doc"],["max"],["cab"],["may"],["tin"],["pew"]]
     * Expected [["doc"],["bar"],["buy"],["ill"],["may"],["tin"],["cab"],["pew"],["max"],["duh"]]
     *
     */
    public static int hash(String s) {
        if (s == null) return 0;
        int h = 0;
        for (int i = 0; i < s.length(); ++i) {
            h += (1 + (s.charAt(i) - 'a'));
        }
        return h;
    }

    public static String sort(String s) {
        if (isEmpty(s)) return s;
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }

    public static boolean isEmpty(String s) {
        return s == null;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (isEmpty(s1) && isEmpty(s2)) return true;
        if (s1.length() != s2.length()) return false;
        String sortedS1 = sort(s1);
        String sortedS2 = sort(s2);
        for (int i = 0; i < sortedS1.length(); ++i) {
            if (sortedS1.charAt(i) != sortedS2.charAt(i)) return false;
        }
        return true;
    }

    static public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<Integer, List<List<String>>> m = new HashMap<>();
        for (String i : strs) {
            if (isEmpty(i)) continue;
            int hash = hash(i);
            List<List<String>> grouped = m.computeIfAbsent(hash, k -> new ArrayList<>());
            List<String> newGroup = null;
            if (grouped.isEmpty()) {
                newGroup = new ArrayList<>();
                grouped.add(newGroup);
            } else {
                for (int iG = 0; iG < grouped.size(); ++iG) {
                    if (isAnagram(grouped.get(iG).get(0), i)) {
                        newGroup = grouped.get(iG);
                        break;
                    }
                }
            }
            if (newGroup == null) {
                newGroup = new ArrayList<>();
                grouped.add(newGroup);
            }
            newGroup.add(i);
        }
        List<List<String>> o = new ArrayList<>();
        m.forEach((k, v) -> o.addAll(v));
        return o;
    }

    static public List<List<String>> groupAnagramsSoln(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for(String i : strs) {
            if(i == null) continue;
            m.computeIfAbsent(sort(i), k -> new ArrayList<>()).add(i);
        }
        List<List<String>> o = new ArrayList<>();
        m.forEach((k, v) -> o.add(v));
        return o;
    }

    public static void main(String[] args) {
        String[] a = new String[]{
                "eat", "teaa", "tan", "ate", "nat", "bat", "aate", "olphckcyufdqmlglimklfzktgygdttnhcvpfdfbrpv",
                "volphckcyufdqmlglimklfzktgygdttnhcvpfdfbrp", "", null
        };
        System.out.println(groupAnagramsSoln(a));
        a = new String[]{
                "ill", "lil", "udh", "hitesh", "sitehh", "fuck", "uckf", "suck", "scuk", "duh", "cab", "tin", "pew", "may", "buy", "bar", "max", "doc"
        };
        System.out.println(groupAnagramsSoln(a));
        a = new String[]{
                "duh", "ill", "cab", "tin", "pew", "may", "buy", "bar", "max", "doc"
        };
        System.out.println(groupAnagramsSoln(a));
    }

}
