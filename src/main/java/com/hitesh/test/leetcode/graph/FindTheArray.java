package com.hitesh.test.leetcode.graph;

import java.io.*;
import java.util.*;
import static java.lang.Math.*;
public class FindTheArray {

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        solver(in, pw);
        pw.close();
    }
    static void solver(InputReader in, PrintWriter pw) throws Exception {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = in.nextInt(), m = in.nextInt();
            CHECK(1, (int) 1e5, n);
            CHECK(0, (int) 1e5, m);
            List<Integer> g[] = genList(n);
            List<Integer> r[] = genList(n);
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                CHECK(1, (int)1e9, b[i]);
            }
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                char sign = in.next().charAt(0);
                int v = in.nextInt();
                CHECK(1, n, u);
                CHECK(1, n, v);
                if (u == v) throw new RuntimeException("i = j");
                u--;
                v--;
                if (sign == '>') { //swap
                    int tmp = u;
                    u = v;
                    v = tmp;
                }
                g[u].add(v);
                r[v].add(u);
            }
            int[] order = topologicalSort(g);
            if (order == null) {
                pw.println("NO");
            } else {
                int[] a = new int[n];
                for (int u : order) {
                    int max = 1;
                    for (int v : r[u]) {
                        max = max(max, a[v] + 1);
                    }
                    a[u] = max;
                }
                int k = binarySearch(n, a, b, order, r);
                boolean ok = check(k, n, a, b, order, r);
                if (!ok || !isCorrectSolution(n, a, b, g)) {
                    throw new RuntimeException("WRONG ANSWER");
                }
                pw.println("YES");
                for (int i = 0; i < n; i++) {
                    pw.print(a[i]);
                    if (i < n - 1) pw.print(" ");
                    else pw.println();
                }
            }
        }
        pw.close();
    }
    static void CHECK(int l, int r, int val) {
        if (val < l || val > r) throw new RuntimeException("Value out of bound");
    }
    static void reverseArray(int a[]){
        for(int i = 0, j = a.length-1; i < j; i++, j--){
            int temp = a[i]; a[i] = a[j]; a[j] = temp;
        }
    }
    static boolean check_2(int k, int n, int b[], int order[], List<Integer> g[]) {
        long [] l = new long[n], r = new long[n];
        for(int i = 0; i < n; i++) {
            if (i < k) {
                l[i] = r[i] = b[i];
            }
            else {
                l[i] = 1;
                r[i] = (long)1e15;
            }
        }
        for (int u : order) {
            for (int v : g[u]) {
                l[u] = max(l[u], l[v] + 1);
            }
        }
        reverseArray(order);
        for (int u : order) {
            for (int v : g[u]) {
                r[v] = min(r[v], r[u] - 1);
            }
        }
        reverseArray(order);
        for(int u = 0; u < n; u++) {
            if (l[u] > r[u]) {
                return false;
            }
        }
        for(int u = 0; u < n; u++) {
            if (r[u] > b[u]) {
                return true;
            }
            if (r[u] < b[u]) {
                return false;
            }
        }
        return false;
    }
    static boolean check(int k, int n, int a[], int b[], int order[], List<Integer> r[]) {
        a[k] = max(a[k], b[k] + 1);
        for (int i = 0; i < k; i++) {
            a[i] = max(a[i], b[i]);
            if (a[i] > b[i]) return false;
        }
        //debug("K", k, a);
        for (int u : order) {
            int max = 1;
            for (int v : r[u]) {
                max = max(max, a[v] + 1);
            }
            a[u] = max(a[u], max);
        }
        for (int i = 0; i < k; i++) {
            if (a[i] > b[i]) return true;
            if(a[i] < b[i]) return false;
        }
        return true;
    }
    static int binarySearch(int n, int a[], int b[], int order[], List<Integer> r[]) {
        int lo = 0, hi = n - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (!check_2(mid, n, b, order, r)) hi = mid;
            else lo = mid + 1;
        }
        if (lo > 0 && !check_2(lo, n, b, order, r)) {
            lo--;
        }
        return lo;
    }
    static boolean isCorrectSolution(int n, int a[], int b[], List<Integer> g[]) {
        for (int u = 0; u < n; u++) {
            for (int v : g[u]) {
                if (a[u] >= a[v]) return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) return false;
            if (a[i] > b[i]) return true;
        }
        return false;
    }
    static <T> List<T>[] genList(int n) {
        List<T> list[] = new List[n];
        for (int i = 0; i < n; i++) list[i] = new ArrayList<T>();
        return list;
    }
    public static int[] topologicalSort(List<Integer> g[]) {
        int n = g.length;
        int[] ec = new int[n];
        for (int i = 0; i < n; i++) {
            for (int to : g[i]) ec[to]++;
        }
        int[] ret = new int[n];
        int q = 0;
        // sources
        for (int i = 0; i < n; i++) {
            if (ec[i] == 0) ret[q++] = i;
        }
        for (int p = 0; p < q; p++) {
            for (int to : g[ret[p]]) {
                if (--ec[to] == 0) ret[q++] = to;
            }
        }
        // loop
        for (int i = 0; i < n; i++) {
            if (ec[i] > 0) return null;
        }
        return ret;
    }
    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }
        public String next() throws Exception {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }
        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}