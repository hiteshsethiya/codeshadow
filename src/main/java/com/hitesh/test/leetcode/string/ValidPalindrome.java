package com.hitesh.test.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidPalindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     *
     * Example 1:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     *
     * Example 2:
     *
     * Input: "race a car"
     * Output: false
     */

    public static final Set<Character> set =
            "abcdefghikjlmnopqrstuvwxyzABCDEFGHIKJLMNOPQRSTUVWXYZ1234567890".chars().mapToObj(c -> (char)c).collect(Collectors.toSet());

    static public boolean isPalindrome(String s) {
        if(s == null || s.trim().isEmpty() || s.length() == 1) return true;
        s = s.trim();
        for(int i = 0, j = s.length() - 1; i <= j; ++i, --j) {
            while(!set.contains(s.charAt(i))) {
                ++i;
                if(i >= s.length()) return true;
            }
            while(!set.contains(s.charAt(j))) {
                --j;
                if(j < 0) return true;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(".")); // Expected true
        System.out.println(isPalindrome("")); // Expected true
        System.out.println(isPalindrome(".,")); // Expected true
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abad"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

}
