package com.hitesh.test.leetcode.string;

import java.util.Stack;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        int maxLen = 0;
        Stack<Integer> fileStack = new Stack<>();
        fileStack.push(0);
        for (String fileName : input.split("\n")) {
            boolean isFile = false;
            if (fileName.contains(".")) isFile = true;
            int directoryLevel = fileName.lastIndexOf("\t") + 1;
            while (fileStack.size() > directoryLevel + 1) {
                fileStack.pop();
            }
            int currentLength = fileStack.peek() + fileName.length() - directoryLevel + 1;
            fileStack.push(currentLength);
            if (isFile) {
                maxLen = Math.max(maxLen, currentLength - 1);
            }
        }
        return maxLen;
    }


    public static void execute(String input, int ans) {
        int o = new LongestAbsoluteFilePath().lengthLongestPath(input);
        System.out.println(o);
        System.out.println(o == ans);
    }

    public static void main(String[] args) {
        execute("dir\n        file.txt", 16);
        execute("dir\n    file.txt", 12);
        execute("dir\n\tfile.txt", 12);
        execute("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext", 20);
        execute("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext", 32);
    }

}
