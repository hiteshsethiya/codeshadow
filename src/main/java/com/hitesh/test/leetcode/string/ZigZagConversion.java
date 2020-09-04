package com.hitesh.test.leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.isEmpty()) return s;
        List<StringBuilder> zigZag = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; ++i)
            zigZag.add(new StringBuilder());
        int i = 0;
        while (i < s.length()) {
            for (int v = 0; i < s.length() && v < numRows; ++v) {
                zigZag.get(v).append(s.charAt(i++));
            }
            for (int o = numRows - 2; i < s.length() && o >= 1; o--) {
                zigZag.get(o).append(s.charAt(i++));
            }
        }
        StringBuilder output = new StringBuilder();
        for(StringBuilder si : zigZag) {
            output.append(si.toString());
        }
        return output.toString();
        //return zigZag.stream().map(StringBuilder::toString).collect(Collectors.joining());
    }

    public static void execute(String input, int n, String exp) {
        String o = new ZigZagConversion().convert(input, n);
        System.out.println(o);
        System.out.println(o.equals(exp));
    }

    public static void main(String[] args) {
        execute("HITES", 3, "HSIET");
        execute("PAYPALISHIRING", 1, "PAYPALISHIRING");
        execute("PAYPALISHIRING", 2, "PYAIHRNAPLSIIG");
        execute("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        execute("PAYPALISHIRING", 4, "PINALSIGYAHRPI");
    }

}
