package com.hitesh.test.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {

    /*
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * Note that 1 does not map to any letters.
     *
     * Example:
     *
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     *
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     */

    static final Map<Integer, String> KEYPAD = new HashMap<>();
    static {
        KEYPAD.put(0, "");
        KEYPAD.put(1, "");
        KEYPAD.put(2, "abc");
        KEYPAD.put(3, "def");
        KEYPAD.put(4, "ghi");
        KEYPAD.put(5, "jkl");
        KEYPAD.put(6, "mno");
        KEYPAD.put(7, "pqrs");
        KEYPAD.put(8, "tuv");
        KEYPAD.put(9, "wxyz");
    }

    static void printWords(int[] a, int currentI, StringBuilder output, List<String> o) {
        if(currentI == output.length()) {
            o.add(output.toString());
            return;
        }

        for(int i = 0; i < KEYPAD.get(a[currentI]).length(); ++i) {
            output.setCharAt(currentI, KEYPAD.get(a[currentI]).charAt(i));
            printWords(a, currentI + 1, output, o);
            if(a[currentI] == 1 || a[currentI] == 0) {
                return;
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.trim().isEmpty()) return new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < digits.length(); ++i) {
            s.append("X");
        }
        int[] a = new int[digits.length()];
        for(int i = 0; i < digits.length(); ++i) {
            a[i] = digits.charAt(i) - '0';
        }
        List<String> o = new ArrayList<>();
        printWords(a, 0, s, o);
        return o;
    }

}
