package com.hitesh.test.g4gcourse.array;

import java.util.*;

public class KSubString {
    static void solve(String s, int k)
    {
        // count of sub-strings, length,
        // initial position of sliding window
        int count = 0, length = 0, pos = 0;

        // map to store the frequency of
        // the characters of sub-string
        HashMap<Character, Integer> m =
                new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++)
        {

            // increase the frequency of the character
            // and length of the sub-string
            if(m.containsKey(s.charAt(i)))
                m.put(s.charAt(i), m.get(s.charAt(i))+1);
            else
                m.put(s.charAt(i), 1);

            length++;

            // if the length of the sub-string
            // is greater than K
            if (length > k)
            {

                // remove the character from
                // the beginning of sub-string
                m.put(s.charAt(pos), m.get(s.charAt(pos)) -1 );
                pos++;
                length--;
            }

            // if the length of the sub string
            // is equal to k and frequency of one
            // of its characters is equal to the
            // length of the sub-string
            // i.e. all the characters are same
            // increase the count
            if (length == k && m.get(s.charAt(i)) == length)
                count++;
        }

        // display the number
        // of valid sub-strings
        System.out.println( 2 * count);
    }

    public static int perfectSubstring(String s, int k) {
        // Write your code here
        int count = 0, l = 0, p = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            m.put(s.charAt(i), (m.getOrDefault(s.charAt(i), 0) + 1));
            l++;

            if(l > k) {
                m.put(s.charAt(p), m.get(s.charAt(p)) - 1);
                ++p; l--;
            }
            if(l == k && m.get(s.charAt(i)) == l) {
                count++;
            }
        }
        return 2 * count;
    }

    // Driver code
    public static void main (String[] args) {

        String s = "1102021222";
        int k = 2;
        solve(s, k);
        System.out.println(perfectSubstring(s, k));
        s = "1020122";
        k = 2;
        solve(s, k);
        System.out.println(perfectSubstring(s, k));
        /*Integer[] a = {2, 1, 2, 3, 4};
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(new ArrayList<>());
        queries.get(0).add(1);
        queries.get(0).add(2);
        System.out.println(getElements(Arrays.asList(a), queries));*/

    }

    public static List<Integer> getElements(List<Integer> arr, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> o = new ArrayList<>();
        for (List<Integer> query : queries) {
            int idx = arr.get(0) * (query.get(0) - 1) + (query.get(1));
            o.add(arr.get(idx));
        }
        return o;
    }
}
