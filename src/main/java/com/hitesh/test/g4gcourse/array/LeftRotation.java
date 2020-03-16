package com.hitesh.test.g4gcourse.array;

import java.util.Arrays;

public class LeftRotation {

    public static void leftRotate(int[] a, int k) {
        int j = a.length - k, t = a[j];
        for(int i = 0; i < a.length; ++i) {
            j = (a.length + i - k) % a.length;

        }

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        leftRotate(a, 2);
        System.out.println(Arrays.toString(a));
    }

}
