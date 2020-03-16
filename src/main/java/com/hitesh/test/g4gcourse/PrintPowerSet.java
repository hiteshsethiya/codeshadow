package com.hitesh.test.g4gcourse;

import java.util.*;

public class PrintPowerSet {

    static void powerSetRecur(String s, String curr, ArrayList<String> output, int i) {
        if(i == s.length()) {
            if(!curr.isEmpty()) output.add(curr);
            return;
        }
        powerSetRecur(s, curr, output, i + 1);
        powerSetRecur(s, curr + s.charAt(i), output, i + 1);
    }

    static ArrayList<String> powerSet(String s)
    {
        // add your code here
        ArrayList<String> output = new ArrayList<>();

        powerSetRecur(s, "", output, 0);

        return output;
    }

    public static void main(String[] args) {

        ArrayList<String> o = powerSet("abc");
        Collections.sort(o);
        System.out.println(Arrays.toString(o.toArray()));
    }

}
