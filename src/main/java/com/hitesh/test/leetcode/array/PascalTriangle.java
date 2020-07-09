package com.hitesh.test.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> o = new ArrayList<>(numRows);

        if(numRows <= 0) return o;
        o.add(new ArrayList<>());
        o.get(0).add(1);

        for(int i = 1; i < numRows; ++i) {
            List<Integer> iList = new ArrayList<>(i + 1);
            iList.add(0, 1);
            for(int j = 1; j <= i - 1; ++j) {
                iList.add(j, o.get(i - 1).get(j - 1) + o.get(i - 1).get(j));
            }
            iList.add(i, 1);
            o.add(iList);
        }
        return o;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(4));
        System.out.println(new PascalTriangle().generate(5));
        System.out.println(new PascalTriangle().generate(1));
        System.out.println(new PascalTriangle().generate(0));
    }

}
