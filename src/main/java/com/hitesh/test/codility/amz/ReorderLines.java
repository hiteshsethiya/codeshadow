package com.hitesh.test.codility.amz;

import java.util.Comparator;
import java.util.List;

public class ReorderLines {

    public List<String> reorderLines(int logFileSize, List<String> logLines) {
        // WRITE YOUR CODE HERE
        logLines.sort(logFileComparator());
        return logLines;
    }

    private Comparator<String> logFileComparator() {
        return (logLine1, logLine2) -> {
            int spaceIndex1 = logLine1.indexOf(' ');
            int spaceIndex2 = logLine2.indexOf(' ');

            //get first character of the work present after the identifier
            char log1FirstChar = logLine1.charAt(spaceIndex1 + 1);
            char log2FirstChar = logLine2.charAt(spaceIndex2 + 1);

            if (log1FirstChar <= '9') {
                if (log2FirstChar <= '9')
                    return 0;
                else
                    return 1;
            }
            if (log2FirstChar <= '9')
                return -1;

            String log1 = logLine1.substring(spaceIndex1 + 1);
            String log2 = logLine2.substring(spaceIndex2 + 1);

            int compareV = log1.compareTo(log2);
            if (compareV == 0) {
                String identifier1 = logLine1.substring(0, spaceIndex1);
                String identifier2 = logLine2.substring(0, spaceIndex2);
                return identifier1.compareTo(identifier2);
            }
            return compareV;
        };
    }

    public static void main(String[] args) {

    }

}
