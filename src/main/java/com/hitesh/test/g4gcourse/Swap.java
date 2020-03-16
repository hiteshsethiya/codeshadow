package com.hitesh.test.g4gcourse;

public class Swap {
    public static String decimalToBinary(int n) {
        StringBuilder str = new StringBuilder();

        if (n == 0) {
            str.append("0");
        }

        while (n > 0) {
            str.append(n % 2);
            n /= 2;
        }
        String result = new StringBuilder(str.toString()).reverse().toString();

        if(8 - result.length() > 0) {
            StringBuilder zeros = new StringBuilder();
            for(int i = 0; i < 8 - result.length(); ++i) {
                zeros.append("0");
            }
            result = zeros + result;
        }

        return result;

    }

    public static int binaryToDecimal(String bin) {
        int n = 0;
        for (int i = 0, j = bin.length() - 1; j >= 0; ++i, --j) {
            if (bin.charAt(j) == '1') {
                n += Math.pow(2, i);
            }
        }
        return n;
    }

    // Function to swap odd and even bits
    public static int swapBits(int n) {

        // Your code
        String binary = decimalToBinary(n);
        StringBuilder swapped = new StringBuilder();
        for(int i = 0, j = 1; j < binary.length(); i += 2, j += 2) {
            swapped.append(binary.charAt(j)).append(binary.charAt(i));
        }
        return binaryToDecimal(swapped.toString());
    }

    public static void main(String[] args) {
        System.out.println(swapBits(0));
    }
}
