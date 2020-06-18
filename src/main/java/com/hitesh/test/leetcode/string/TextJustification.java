package com.hitesh.test.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth == 0) return new ArrayList<>();
        List<String> justifiedText = new ArrayList<>();
        int i = 0, n = words.length;
        while (i < n) {
            int j = i + 1;
            int width = words[i].length();
            while(j < n && (width + words[j].length() + (j - i - 1) < maxWidth)) {
                width += words[j].length();
                ++j;
            }
            int totalSpaces = maxWidth - width;
            if(j - i == 1 || j >= n) {
                justifiedText.add(leftJustify(words, totalSpaces, i, j));
            } else {
                justifiedText.add(middleJustify(words, totalSpaces, i, j));
            }
            i = j;
        }
        return justifiedText;
    }

    private String leftJustify(String[] words, int totalSpaces, int i, int j) {
        int spacesToTheRight = totalSpaces - (j - i - 1);
        StringBuilder justifiedText = new StringBuilder(words[i]);
        for(int k = i + 1; k < j; ++k) {
            justifiedText.append(" ").append(words[k]);
        }
        justifiedText.append(spaces(spacesToTheRight));
        return justifiedText.toString();
    }

    public String middleJustify(String[] words, int totalSpaces, int i, int j) {
        int spacesNeeded = j - i - 1;
        int space = totalSpaces / spacesNeeded;
        int extraSpace = totalSpaces % spacesNeeded;
        StringBuilder justifiedText = new StringBuilder(words[i]);
        for(int k = i + 1; k < j; ++k) {
            justifiedText.append(spaces(space + (extraSpace-- > 0 ? 1 : 0)))
                    .append(words[k]);
        }
        return justifiedText.toString();
    }

    public String spaces(int spaces) {
        if (spaces == 1) return " ";
        StringBuilder sb = new StringBuilder();
        while (spaces-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(new TextJustification().fullJustify(words, maxWidth));
        words = new String[]
                {"Science","is","what","we","understand","well","enough","to","explain","to","a"
                        ,"computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        System.out.println(new TextJustification().fullJustify(words, maxWidth));
    }
}
