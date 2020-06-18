package com.hitesh.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtil {

    public static <T> boolean isEqual(List<T> a, List<T> b) {
        if(a.size() != b.size()) return false;
        Set<T> aSet = new HashSet<>(a);
        for (T t : b) {
            if (!aSet.contains(t)) return false;
        }
        return true;
    }

}
