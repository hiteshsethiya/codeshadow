package com.hitesh.test.g4gcourse.array.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTripletForFormula {
    // a * a + b * b = c * c
    // a2 + b2 - c2 = 0

    static List<Integer> getTriplet(int[] a) {
        Arrays.sort(a);
        List<Integer> ans = new ArrayList<>();
        for(int i = a.length - 1; i >=0 ; --i) {
            long c = a[i] * a[i];
            for(int j = 0, k = i - 1; j < k;) {
                long x = (a[k] * a[k]) + (a[j] * a[j]);
                if(x == c) {
                    ans.add(a[i]);
                    ans.add(a[j]);
                    ans.add(a[k]);
                    return ans;
                } else if(x > c) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    static int count(int[] a) {
        Arrays.sort(a);
        int ans = 0;
        for(int i = a.length - 1; i >=0 ; --i) {
            long c = a[i] * a[i];
            for(int j = 0, k = i - 1; j < k;) {
                long x = (a[k] * a[k]) + (a[j] * a[j]);
                if(x == c) {
                    ++ans;
                    j++;k--;
                } else if(x > c) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getTriplet(new int[] {1, 2, 3, 4, 5}));
        System.out.println(count(new int[] {1, 2, 3, 4, 5}));
        System.out.println(getTriplet(new int[] {1, 2, 3, 4, 15}));
        System.out.println(count(new int[] {1, 2, 3, 4, 15}));
    }
}
