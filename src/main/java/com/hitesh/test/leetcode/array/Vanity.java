package com.hitesh.test.leetcode.array;

import java.util.*;

public class Vanity {

    static final Map<Character, Integer> KEYPAD = new HashMap<>();

    static {
        KEYPAD.put('A', 2);
        KEYPAD.put('B', 2);
        KEYPAD.put('C', 2);
        KEYPAD.put('D', 3);
        KEYPAD.put('E', 3);
        KEYPAD.put('F', 3);
        KEYPAD.put('G', 4);
        KEYPAD.put('H', 4);
        KEYPAD.put('I', 4);
        KEYPAD.put('J', 5);
        KEYPAD.put('K', 5);
        KEYPAD.put('L', 5);
        KEYPAD.put('M', 6);
        KEYPAD.put('N', 6);
        KEYPAD.put('O', 6);
        KEYPAD.put('P', 7);
        KEYPAD.put('Q', 7);
        KEYPAD.put('R', 7);
        KEYPAD.put('S', 7);
        KEYPAD.put('T', 8);
        KEYPAD.put('U', 8);
        KEYPAD.put('V', 8);
        KEYPAD.put('W', 9);
        KEYPAD.put('X', 9);
        KEYPAD.put('Y', 9);
        KEYPAD.put('Z', 9);
    }

    public static String hash(String s) {
        StringBuilder h = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            h.append(KEYPAD.get(s.charAt(i)));
        }
        return h.toString();
    }

    public static boolean isMatch(String code, String number) {
        return number.contains(code);
    }

    public static List<String> vanity(List<String> codes, List<String> numbers) {
        if (codes == null || codes.isEmpty() || numbers == null || numbers.isEmpty()) {
            return numbers;
        }
        Map<String, Set<String>> codeToNumber = new HashMap<>();
        for (String c : codes) {
            c = c.trim();
            codeToNumber.put(hash(c), new HashSet<>());
        }
        for (String i : codeToNumber.keySet()) {
            for (String n : numbers) {
                if (isMatch(i, n)) {
                    codeToNumber.get(i).add(n);
                    break;
                }
            }
        }
        List<String> o = new ArrayList<>();
        for(Set<String> i : codeToNumber.values()) {
            o.addAll(i);
        }
        o.sort(String::compareTo);
        return o;
    }

    public static void main(String[] args) {

        List<String> c = new ArrayList<>();
        c.add("TWLO");
        c.add("CODE");
        c.add("HTCH");
        List<String> n = new ArrayList<>();
        n.add("+14157088956");
                n.add("+15108956333");
                n.add("+17474824380");
                n.add("+1415123456");
                n.add("+919810155555");
        System.out.println(vanity(c, n));

    }
}
