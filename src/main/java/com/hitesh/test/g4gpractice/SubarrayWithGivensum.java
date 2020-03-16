package com.hitesh.test.g4gpractice;

public class SubarrayWithGivensum {


    public static void sum(int[] a, int s) {

        for(int i = 0; i < a.length; ++i) {
            int currSum = a[i];
            for(int j = i + 1; j < a.length; ++j) {
                currSum += a[j];
                if(currSum == s) {
                    System.out.println((i + 1) + " " + (j + 1));
                    break;
                }
            }
            if(currSum == s) break;
        }

    }

    public static void main(String[] args) {
        sum(new int[] {1,2,3,7,5}, 12);
    }

}
