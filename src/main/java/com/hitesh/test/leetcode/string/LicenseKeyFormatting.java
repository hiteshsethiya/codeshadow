package com.hitesh.test.leetcode.string;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder license = new StringBuilder();
        String[] keys = s.split("-");
        for (int j = keys.length - 1; j >= 0; ) {
            StringBuilder iKey = new StringBuilder();
            int iK = k;
            while (j >= 0 && iK > 0) {
                String iVal = keys[j];
                int startIdx = Math.max(iVal.length() - iK, 0);
                String subStr = iVal.substring(startIdx);
                iKey.insert(0, subStr);
                iK -= subStr.length();
                if (startIdx > 0) {
                    keys[j] = iVal.substring(0, startIdx);
                } else {
                    j--;
                }
            }
            if(iKey.length() > 0) license.insert(0, iKey).insert(0, "-");
        }
        return license.replace(0, 1, "").toString().toUpperCase();
    }

    public static void execute(String s, int k, String ans) {
        String out = new LicenseKeyFormatting().licenseKeyFormatting(s, k);
        System.out.println(out);
        System.out.println(out.equals(ans));
    }

    public static void main(String[] args) {
        execute("--a-a-a-a--", 2,  "AA-AA");
        execute("5F3Z-2e-9-w", 1, "5-F-3-Z-2-E-9-W");
        execute("5F3Z-2e-9-w", 2, "5F-3Z-2E-9W");
        execute("5F3Z-2e-9-w", 3, "5F-3Z2-E9W");
        execute("5F3Z-2e-9-w", 4, "5F3Z-2E9W");
        execute("5F-3Ze", 4, "5-F3ZE");
        execute("2-5g-3-J", 2, "2-5G-3J");
    }

}
