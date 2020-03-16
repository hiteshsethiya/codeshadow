package com.hitesh.test;

import java.io.*;

public class solution {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(b.readLine());
        while (t-- > 0) {
            String[] p = b.readLine().split(" ");
            int m = Integer.parseInt(p[0]);
            int n = Integer.parseInt(p[1]);
            int[][] a = new int[m][n];
            for (int i = 0; i < m; ++i) {
                p = b.readLine().split(" ");
                for (int j = 0; j < n; ++j) {
                    a[i][j] = Integer.parseInt(p[j]);
                }
            }
            if (m <= 1 && n <= 1) {
                System.out.println("1");
                continue;
            }
            int e = a[0][0];
            int d = e == 1 ? 0 : 1; boolean f = true;
            o:
            for (int i = 0; i < m; ++i) {
                int l = i % 2 == 0 ? e : d;
                for (int j = 0; j < n; ++j) {
                    if (j % 2 == 0 && a[i][j] != l) {
                        System.out.println("0");
                        f = false;
                        break o;
                    } else if (j % 2 != 0 && a[i][j] == l) {
                        System.out.println("0");
                        f = false;
                        break o;
                    }
                }
            }
            if(f) System.out.println("1");
        }
        b.close();
    }
}