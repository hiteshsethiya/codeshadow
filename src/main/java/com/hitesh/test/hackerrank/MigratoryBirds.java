package com.hitesh.test.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MigratoryBirds {


    public static int migratoryBirds(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new TreeMap<>();
        for(Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, map.get(i));
        }

        int smallId = Integer.MAX_VALUE;

        for(Integer i : map.keySet()) {
            if(max == map.get(i)) {
                smallId = Math.min(smallId, i);
            }
        }
        return smallId;
    }

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(5);
        a.add(3);

        System.out.println(migratoryBirds(a));
    }

}
