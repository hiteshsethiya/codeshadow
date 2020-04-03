package com.hitesh.test.leetcode.number;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FractiontoRecurringDecimal {

    /*
     * Given two integers representing the numerator and
     * denominator of a fraction, return the fraction in string format.
     *
     * If the fractional part is repeating, enclose the repeating part in parentheses.
     *
     * Example 1:
     *
     * Input: numerator = 1, denominator = 2
     * Output: "0.5"
     * Example 2:
     *
     * Input: numerator = 2, denominator = 1
     * Output: "2"
     * Example 3:
     *
     * Input: numerator = 2, denominator = 3
     * Output: "0.(6)"
     */


    /** Expected O/P:
     * n = 2147483647, d = 27
     * Expected
     * "79536431.(370)"
     *
     * n = -2147483648, d = 27
     * Expected
     * "-79536431.(407)"
     *
     * n = 1, d = 6
     * Expected
     * "0.1(6)"
     *
     * n = 1, d = 214748364
     * Expected
     * "0.00(000000465661289042462740251655654056577585848337359161441621040707904997124914069194026549138227660723878669455195477065427143370461252966751355553982241280310754777158628319049732085502639731402098131932683780538602845887105337854867197032523144157689601770377165713821223802198558308923834223016478952081795603341592860749337303449725)"
     */

    static public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator, d = denominator;
        if(n == 0 || d == 0) return "0";
        String ans = "";
        int sign = (n < 0 ? -1 : 1) * (d < 0 ? -1 : 1);
        ans = sign == 1 ? "" : "-";
        n = Math.abs(n);
        d = Math.abs(d);
        if (n >= d) {
            ans += (n / d);
            n %= d;
            if (n == 0) {
                return ans;
            }
            ans += ".";
        } else {
            ans += "0.";
        }
        Map<Long, Integer> remainderToIndex = new HashMap<>();
        int i = 0;
        remainderToIndex.put(n, 0);
        n *= 10;
        String subAns = "";
        while (n > 0) {
            while(n < d) {
                n *= 10;
                subAns += "0";
            }
            long remainder = (n % d);
            subAns += n / d;
            if(remainder == 0) {
                break;
            }
            if(remainderToIndex.containsKey(remainder)) {
                int j = remainderToIndex.get(remainder);
                subAns = subAns.substring(0, j) + "(" + subAns.substring(j) + ")";
                break;
            }
            remainderToIndex.put(remainder, ++i);
            remainderToIndex.put(n, ++i);
            n = remainder * 10;
            if(remainderToIndex.containsKey(n)) {
                subAns += "0";
                int j = remainderToIndex.get(n);
                subAns = subAns.substring(0, j) + "(" + subAns.substring(j) + ")";
                break;
            }
        }
        return ans + subAns;
    }

    public static void main(String[] args) {
        System.out.println(1 / 214748364 + " -> " + fractionToDecimal(1, 214748364));
        System.out.println(0 / 6 + " -> " + fractionToDecimal(0, 6));
        System.out.println(1 / 6 + " -> " + fractionToDecimal(1, 6));
        System.out.println(Integer.MAX_VALUE / 27.0 + " -> " + fractionToDecimal(Integer.MAX_VALUE, 27));
        System.out.println(Integer.MIN_VALUE / 27.0 + " -> " + fractionToDecimal(Integer.MIN_VALUE, 27));
        System.out.println(-19.0 / 27.0 + " -> " + fractionToDecimal(19, 27));
        System.out.println(-190.0 / -27.0 + " -> " + fractionToDecimal(190, 27));
        System.out.println(4.0 / -9.0 + " -> " + fractionToDecimal(4, 9));
        System.out.println(4.0 / 333.0 + " -> " + fractionToDecimal(4, 333));
        System.out.println(4.0 / 3333.0 + " -> " + fractionToDecimal(4, 3333));
        System.out.println(4.0 / 2.0 + " -> " + fractionToDecimal(4, 2));
        System.out.println(2.0 / 4.0 + " -> " + fractionToDecimal(2, 4));
    }

}
