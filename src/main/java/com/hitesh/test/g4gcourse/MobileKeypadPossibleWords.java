package com.hitesh.test.g4gcourse;

import java.util.HashMap;
import java.util.Map;

public class MobileKeypadPossibleWords {

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

    static void printWords(int a[], int currentI, StringBuilder output) {
        if(currentI == output.length()) {
            System.out.print(output.toString() + " ");
            return;
        }

        for(int i = 0; i < KEYPAD.get(a[currentI]).length(); ++i) {
            output.setCharAt(currentI, KEYPAD.get(a[currentI]).charAt(i));
            printWords(a, currentI + 1, output);
            if(a[currentI] == 1 || a[currentI] == 0) {
                return;
            }
        }
    }

    static void possibleWords(int a[], int N) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < N; ++i) {
            s.append("X");
        }
        printWords(a, 0, s);
    }

    public static void main(String[] args) {
        possibleWords(new int[] {2, 3, 4}, 3);
    }

}
