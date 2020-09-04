package com.hitesh.test.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE, w1 = words.length, w2 = -words.length;
        for(int i = 0; i < words.length; ++i) {
            if(words[i].equals(word1)) w1 = i;
            if(words[i].equals(word2)) w2 = i;
            min = Math.min(min, Math.abs(w1 - w2));
        }
        return min;
    }
}
