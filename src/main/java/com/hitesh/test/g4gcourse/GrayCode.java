package com.hitesh.test.g4gcourse;

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
//Back-end complete function Template for Java
class GrayCode {


    public static String decimalToBinary(int n ) {
        StringBuilder str = new StringBuilder();

        if(n == 0) {
            str.append("0");
        }

        while(n > 0) {
            str.append(n % 2);
            n /= 2;
        }
        return new StringBuilder(str.toString()).reverse().toString();
    }

    public static int binaryToDecimal(String bin) {
        int n = 0;
        for(int i = 0, j = bin.length() - 1; j >= 0; ++i, --j) {
            if(bin.charAt(j) == '1') {
                n += Math.pow(2, i);
            }
        }
        return n;
    }

    public static char xorc(char a, char b) {
        return a == b ? '0' : '1';
    }

    public static String binaryToGray(String binary) {
        StringBuilder gray = new StringBuilder(binary.charAt(0) + "");
        for(int i = 1; i < binary.length(); ++i) {
            gray.append(xorc(binary.charAt(i - 1), binary.charAt(i)));
        }
        return gray.toString();
    }

    //  Function to find the gray code of given number N
    public static int greyConverter(int n) {

        // Your code here
        String bin = decimalToBinary(n);
        String gray = binaryToGray(bin);
        return binaryToDecimal(gray);
    }

    public static void main(String[] args) {
        System.out.println(greyConverter(0));
        System.out.println(greyConverter(7));
        System.out.println(greyConverter(999));
    }

}
