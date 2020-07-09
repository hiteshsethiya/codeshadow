package com.hitesh.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtil {

    public static <T> boolean isEqual(List<T> a, List<T> b) {
        if (a.size() != b.size()) return false;
        Set<T> aSet = new HashSet<>(a);
        for (T t : b) {
            if (!aSet.contains(t)) return false;
        }
        return true;
    }

    public static void generateArraySequential(int start, int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; ++i) {
            a[i] = start++;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
//        generateArraySequential(1, 20000);
        generateArray("[[1,3], [0,2], [1,3], [0,2]]");
        generateArray("[[1,2,3], [0,2], [0,1,3], [0,2]]");
        generateArray("[[2,3],[1,2],[1,3]]");
    }

    public static void generateArray(String s) {
        s = s.replaceAll("\\[", "{");
        s = s.replaceAll("]", "}");
        System.out.println(s);
    }
}
