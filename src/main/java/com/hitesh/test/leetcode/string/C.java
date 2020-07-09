package com.hitesh.test.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C {

    public static String[] getFolderNames(String[] names) {
        if(names == null || names.length == 0) return names;
        int n = names.length;
        Map<String, Integer> alreadyUsedToFrequency = new HashMap<>();
        String[] output = new String[n];

        for(int i = 0; i < n; ++i) {
            String iFileName = names[i];
            if(!alreadyUsedToFrequency.containsKey(iFileName)) {
                // Doesn't contain. Just add
                alreadyUsedToFrequency.put(iFileName,1);
                output[i] = iFileName;
            } else {
                // Already exists
                int k = alreadyUsedToFrequency.get(iFileName); // no of times it has already occurred
                String suffix = "(" + k + ")";
                String newFileName = iFileName + suffix;
                while(alreadyUsedToFrequency.containsKey(newFileName)) {
                    k++;
                    suffix = "(" + k + ")";
                    newFileName = iFileName + suffix;
                }
                alreadyUsedToFrequency.put(newFileName,1);
                alreadyUsedToFrequency.put(iFileName,alreadyUsedToFrequency.getOrDefault(iFileName, 0) + 1);
                output[i] = newFileName;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFolderNames(new String[]{
                "onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"
        })));
        System.out.println(Arrays.toString(getFolderNames(new String[]{
                "kaido", "kaido(1)", "kaido", "kaido(1)"
        })));
    }



}
