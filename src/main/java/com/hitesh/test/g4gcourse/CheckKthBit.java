package com.hitesh.test.g4gcourse;

public class CheckKthBit {

    static boolean checkKthBit(int n, int k){

        // Your code here
        return (n & (1 << k)) > 0;

    }



    public static void main(String[] args) {
        /*System.out.println(checkKthBit(0, 0));
        System.out.println(checkKthBit(4, 0));
        System.out.println(checkKthBit(4, 2));
        System.out.println(checkKthBit(500, 3));
        System.out.println(checkKthBit(500, 3444));*/
        int hack = 15;
        int hacker = 20;
        first : {
            second : {
                if(hacker == hack >> 1) {
                    break second;
                }
            }
            System.out.println(hack);
        }
        System.out.println(hacker);
    }
}
