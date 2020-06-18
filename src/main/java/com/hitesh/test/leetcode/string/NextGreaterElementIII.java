package com.hitesh.test.leetcode.string;

import java.util.Arrays;

public class NextGreaterElementIII {

    /*
     * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer
     * which has exactly the same digits existing in the integer n and is greater in value than n.
     * If no such positive 32-bit integer exists, you need to return -1.
     *
     * Example 1:
     *
     * Input: 12
     * Output: 21
     *
     * Example 2:
     *
     * Input: 21
     * Output: -1
     */

    public int nextGreaterElement(int n) {
        if (n < 10) return -1;
        String number = String.valueOf(n);
        int minNum = -1, iPrev = number.charAt(number.length() - 1) - '0';
        for (int i = number.length() - 2; i >= 0; --i) {
            int digit = number.charAt(i) - '0';
            if (digit < iPrev) {
                char[] numbers = number.toCharArray();
                int min = Integer.MAX_VALUE, minPos = i;
                for (int j = i + 1; j < numbers.length; ++j) {
                    int iMin = numbers[j] - '0';
                    if (iMin > digit && iMin < min) {
                        min = iMin;
                        minPos = j;
                    }
                }
                char t = numbers[i];
                numbers[i] = numbers[minPos];
                numbers[minPos] = t;
                Arrays.sort(numbers, i + 1, numbers.length);
                String newNum = new String(numbers);
                try {
                    return Integer.parseInt(newNum);
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
            iPrev = digit;
        }
        return minNum;
    }

    public static void execute(int n, int ans) {
        int o = new NextGreaterElementIII().nextGreaterElement(n);
        System.out.println(o);
        System.out.println(o == ans);
    }

    public static void main(String[] args) {
        execute(1999999999, -1);
        execute(230241, 230412);
        execute(111110, -1);
        execute(1111101, 1111110);
        execute(255, 525);
        execute(12443322, 13222344);
        execute(1221, 2112);
        execute(12, 21);
        execute(21, -1);
    }

}
