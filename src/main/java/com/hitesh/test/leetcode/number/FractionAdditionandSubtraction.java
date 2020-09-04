package com.hitesh.test.leetcode.number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FractionAdditionandSubtraction {

    /**
     * Given a string representing an expression of fraction addition and subtraction,
     * you need to return the calculation result in string format.
     * The final result should be irreducible fraction.
     * If your final result is an integer, say 2, you need to change it to
     * the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.
     * <p>
     * Example 1:
     * Input:"-1/2+1/2"
     * Output: "0/1"
     * Example 2:
     * Input:"-1/2+1/2+1/3"
     * Output: "1/3"
     * Example 3:
     * Input:"1/3-1/2"
     * Output: "-1/6"
     * Example 4:
     * Input:"5/3+1/3"
     * Output: "2/1"
     * Note:
     * The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
     * Each fraction (input and output) has format ±numerator/denominator.
     * If the first input fraction or the output is positive, then '+' will be omitted.
     * The input only contains valid irreducible fractions, where the numerator and denominator
     * of each fraction will always be in the range [1,10]. If the denominator is 1, it means this
     * fraction is actually an integer in a fraction format defined above.
     * The number of given fractions will be in the range [1,10].
     * The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
     */

    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static class Tuple {
        int n;
        int d;

        public Tuple(int a, int b) {
            this.n = a;
            this.d = b;
        }
    }

    public String fractionAddition(String expression) {

        if (expression == null || expression.trim().isEmpty()) return expression;
        List<Tuple> fractions = new ArrayList<>();
        int lcm = 1;
        int n = expression.length(), sign = 1;
        for (int i = 0; i < n;) {
            if (expression.charAt(i) == '-') {
                sign = -1;
                ++i;
            } else if (expression.charAt(i) == '+') {
                sign = 1;
                ++i;
            }
            int numerator = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                numerator *= 10;
                numerator += Integer.parseInt(expression.charAt(i++) + "");
            }
            numerator *= sign;
            i++;
            int denominator = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denominator *= 10;
                denominator += Integer.parseInt(expression.charAt(i++) + "");
            }
            denominator = denominator == 0 ? 1 : denominator;
            fractions.add(new Tuple(numerator, denominator));
            lcm = lcm(lcm, denominator);
        }

        Tuple ans = new Tuple(0, 0);
        ans.d = lcm;
        for (Tuple iFraction : fractions) {
            ans.n += (lcm / iFraction.d) * iFraction.n;
        }
        int gcd = Math.abs(gcd(ans.n, ans.d));
        ans.n /= gcd;
        ans.d /= gcd;
        return ans.n + "/" + ans.d;
    }

    public static void execute(String expression, String exp) {
        String output = new FractionAdditionandSubtraction().fractionAddition(expression);
        System.out.println(output);
        System.out.println(output.equals(exp));
    }

    public static void main(String[] args) {
        execute("-1/2+1/2+1/3", "1/3");
        execute("1/3-1/2", "-1/6");
        execute("1/1-1/2", "1/2");
        execute("5/3+1/3", "2/1");
    }
}
