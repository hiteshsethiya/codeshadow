package com.hitesh.test.g4gpractice.string;

public class LexicographicalRank {

    static int fac(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * fac(n - 1);
    }

    // Function to calculate rank of the string.
    static int lexRank(String s) {
        int n = s.length();

        // Initialize total count to 1.
        int t_count = 1;

        // loop to calculate number of smaller strings.
        for (int i = 0; i < n; i++) {

            // Count smaller characters than s[i].
            int less_than = 0;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) > s.charAt(j)) {
                    less_than += 1;
                }
            }

            // Count frequency of duplicate characters.
            int[] d_count = new int[52];

            for (int j = i; j < n; j++) {
                // Check whether the character is upper
                // or lower case and then increase the
                // specific element of the array.
                if ((s.charAt(j) >= 'A') && s.charAt(j) <= 'Z') {
                    d_count[s.charAt(j) - 'A'] += 1;
                } else {
                    d_count[s.charAt(j) - 'a' + 26] +=1;
                }
            }

            // Compute the product of the factorials
            // of frequency of characters.
            // Repeated characters.
            int d_fac = 1;
            for (int ele : d_count)
                d_fac *= fac(ele);

            // add the number of smaller string
            // possible from index i to total count.
            t_count += (fac(n - i - 1) * less_than) / d_fac;
        }

        return t_count;
    }

    public static void main(String[] args) {
        System.out.println(lexRank("settLe"));
        System.out.println(lexRank("abab"));
        System.out.println(lexRank("abc"));
    }

}
