package com.hitesh.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtil {

    public static <T> boolean isEqual(List<T> a, List<T> b) {
        if (a.size() != b.size()) return false;
        Set<T> aSet = new HashSet<>(a);
        for (T t : b) {
            if (!aSet.contains(t)) return false;
        }
        return true;
    }

    public static void generateArraySequential(int start, int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; ++i) {
            a[i] = start++;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
//        generateArraySequential(1, 20000);
//        generateArray("[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]");

        String[] a = {
        };
        String[] b = {
        };

        String q = "REVOKE DROP,CREATE ON `db_name}}`.* FROM 'user_name}}'@'%' ;\n" +
                "GRANT SELECT, INSERT, UPDATE ON `db_name}}`.* TO 'user_name}}'@'%';\n" +
                "FLUSH PRIVILEGES;";

        for(int i = 0; i < a.length; ++i) {
            System.out.println(
                    q.replaceAll(
                            "db_name}}", b[i]
                    ).replaceAll(
                            "user_name}}", a[i]
                    )
            );
        }

    }

    public static void generateArray(String s) {
        s = s.replaceAll("\\[", "{");
        s = s.replaceAll("]", "}");
        System.out.println(s);
    }
}
