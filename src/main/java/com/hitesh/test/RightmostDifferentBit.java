package com.hitesh.test;

public class RightmostDifferentBit {

    static int getFirstSetBitPos(int n) {

        // Your code here
        if (n >= 1) {
            int a = (n) ^ (n - 1);
            return (int) (Math.log(a + 1) / Math.log(2));
        }

        return 0;
    }

    static int posOfRightMostDiffBit(int m, int n)
    {

        // Your code here
        return getFirstSetBitPos((m ^ n));

    }

    public static void main(String[] args) {
        System.out.println(posOfRightMostDiffBit(11, 9));
        System.out.println(posOfRightMostDiffBit(52, 4));
        System.out.println(posOfRightMostDiffBit(2, 4));
        System.out.println(posOfRightMostDiffBit(0, 0));
    }
}
