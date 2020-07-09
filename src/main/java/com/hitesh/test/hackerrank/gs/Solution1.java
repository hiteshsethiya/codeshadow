package com.hitesh.test.hackerrank.gs;

import java.util.*;

public class Solution1 {

    static Set<Integer> getDigits(int n) {
        Set<Integer> digits = new HashSet<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

    static int nonRepeatingDigitProductCount(int x, int y, int z) {
        int count = 0;
        for (int i = y; i <= z; ++i) {
            long product = x * i;
            if (product % 10 == 0 && i % 10 == 0) continue;
            Set<Integer> digits = getDigits(i);
            boolean isValid = true;
            while (product > 0) {
                long digit = product % 10;
                product /= 10;
                if (digits.contains((int) digit)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }
        return count;
    }

    public static List<String> getShrunkArray(List<String> inputArray, int burstLength) {
        Stack<Node> frequencyStack = new Stack<>();
        for (String iString : inputArray) {
            if (!frequencyStack.isEmpty()
                    && !frequencyStack.peek().value.equals(iString)
                    && frequencyStack.peek().frequency >= burstLength) {

                String curr = frequencyStack.peek().value;
                while (frequencyStack.size() > 0 && frequencyStack.peek().value.equals(curr)) {
                    frequencyStack.pop();
                }
            }

            if (!frequencyStack.isEmpty() && frequencyStack.peek().value.equals(iString)) {
                frequencyStack.peek().frequency++;
            } else {
                Node newNode = new Node(iString, 1);
                frequencyStack.push(newNode);
            }
        }
        List<String> res = new ArrayList<>();
        frequencyStack.forEach(elem -> {
            if (elem.frequency < burstLength) {
                while (elem.frequency-- > 0) {
                    res.add(elem.value);
                }
            }
        });
        return res;
    }

    public static class Node {
        String value;
        int frequency;

        Node(String value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
//        System.out.println(nonRepeatingDigitProductCount(2, 10, 15));
        System.out.println(getShrunkArray(
                Arrays.asList("a",
                        "b",
                        "c",
                        "d",
                        "e",
                        "e",
                        "e",
                        "e",
                        "d",
                        "d",
                        "c",
                        "b",
                        "f",
                        "g",
                        "f"), 3
        ));
    }

}
