package com.hitesh.test.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

    /*
     * Given a list of non negative integers, arrange them such that they form the largest number.
     *
     * Example 1:
     *
     * Input: [10,2]
     * Output: "210"
     * Example 2:
     *
     * Input: [3,30,34,5,9]
     * Output: "9534330"
     * Note: The result may be very large, so you need to return a string instead of an integer.
     */

    public static String trimZeros(String a) {
        int i = 0;
        while (i < a.length() && a.charAt(i) == '0') {
            ++i;
        }
        return i > 0 ? a.substring(i) : a;
    }

    public static int compare(String a, String b) {
        String o1 = a + b;
        String o2 = b + a;
        return o2.compareTo(o1);
    }

    static public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        StringBuilder output = new StringBuilder();
        Arrays.stream(nums)
                .mapToObj(i -> i + "")
                .sorted(LargestNumber::compare)
                .forEach(output::append);
        return output.charAt(0) == '0' ? "0" : output.toString();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,7,2,5,8,0,3,6,9};
        System.out.println(largestNumber(a));
        a = new int[]{2, 147, 483, 647, 943};
        System.out.println(largestNumber(a));
        a = new int[]{0,9,8,7,6,5,4,3,2,1};
        System.out.println(largestNumber(a));
        a = new int[]{3,30,34,5,9};
        System.out.println(largestNumber(a));
        a = new int[]{10,2};
        System.out.println(largestNumber(a));
        a = new int[]{0, 0};
        System.out.println(largestNumber(a));
        a = new int[]{1};
        System.out.println(largestNumber(a));
        a = new int[]{1, 1, 1, 1, 1, 1};
        System.out.println(largestNumber(a));
        a = new int[]{1, 1, 1, 1, 1, 9};
        System.out.println(largestNumber(a));
    }

    /*
     * Complexity Analysis
     *
     * Time complexity : O(nlgn)
     *
     * Although we are doing extra work in our comparator, it is only by a constant factor.
     * Therefore, the overall runtime is dominated by the complexity of sort, which is O(nlgn) in Python and Java.
     *
     * Space complexity : O(n)
     *
     * Here, we allocate O(n) additional space to store the copy of nums.
     * Although we could do that work in place (if we decide that it is okay to modify nums),
     * we must allocate O(n) space for the final return string.
     * Therefore, the overall memory footprint is linear in the length of nums.
     */

}
