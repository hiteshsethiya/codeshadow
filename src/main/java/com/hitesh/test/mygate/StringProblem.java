package com.hitesh.test.mygate;

public class StringProblem {

    public static boolean game(String a, String b, int k) {
        for(int i = 0; i < a.length(); ++i) {
            int v = (26 + (b.charAt(i) - 'a') - (a.charAt(i) - 'a'))  % 26;
            if(v > k) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(game("abc", "ddd", 3));
        System.out.println(game("ddd", "abc", 25));
        System.out.println(game("dba", "xyz", 6));
        System.out.println(game("xyz", "abc", 10));
        System.out.println(game("xxx", "ggg", 8));
    }

}
