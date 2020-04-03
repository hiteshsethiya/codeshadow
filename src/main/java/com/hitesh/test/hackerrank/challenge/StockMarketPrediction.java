package com.hitesh.test.hackerrank.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockMarketPrediction {

    /*
     * 4. Stock market prediction
     * In this prediction game, the first player gives the second player some stock market data for some consecutive days.
     * The data contains a company'sstock price on each day. The rules for the game are: Player 1 will tell player 2
     * a day number player 2 has to find the nearest day on which stock price is smaller than the given day
     * If there are two results, then player 2finds the day number which is smaller if no such day exists,
     * then the answer is-1.
     * For example, the image below shows thestock market data for 10 consecutive days.
     * The horizontal axis represents the day number, starting at 1, and the vertical axis represents the stock price on that day.
     * Example
     * n = 10
     * stockData = [5, 6, 8, 4, 9, 10, 8, 3, 6, 4]
     * queries = [6, 5, 4]
     * On day 6, the stock price is 10. Both 9 and 8 are lower prices one day away. Choose 9 (day 5) because it is before day 6.
     * On day 5, the stock price is 9. 4 is the closest lower price on day 4.
     * On day 4, the stock price is 4. The only lower price is on day 8.
     * The return array is [5, 4, 8].
     * predict Answer has 2 parameters: int stockData[n]:the value of each stockData[i] is the stock price on the
     * i+1th day(where 0 ≤ i n).
     * int queries[q]:the value of each element queries[j], isthe day number given in the query(where 0 ≤ j q).
     * Return int[q]: the value at each index iis the answer to queries[i]
     * Constraints 1 ≤ n ≤105
     * 1 ≤ stockData[i] ≤ 109
     * 1 ≤ q ≤ 105
     * 1 ≤ queries[j] ≤ 109
     * Input Format For Custom Testing Locked stub code in the editor reads the following input from stdin and passes it to
     * the function. The first line contains an integer, n, denoting the number of elements in stockData.
     * Each line ith of the n subsequent lines contains an integer, stockData[i], the stock price on the i+1th day.
     * Nextline contains an integer, q, the number of elements in queries. Each line jth of the q subsequent lines
     * contains an integer, queries[j], the day number of the jthquery.
     * Sample Case 0 Sample Input 0 STDIN Function ----- -------- 10→ stockData[] size n = 10 5→stockData = [5, 6, 8, 4, 9, 10, 8, 3, 6, 4] 6 8 4 9 10 8 3 6 4 3→queries[] size q = 3 3→queries = [3, 1, 8] 1 8 Sample Output 0 2 4 -1 Explanation 0 If theday number is 3, both days 2 and 4 are smaller. Choose the earlier day,day 2. If theday number is 1,day 4 is the closest day with a smaller price. If the
     * day number is 8,there is no day where the price is less than 3. The answer is -1. The return array is [2, 4, -1]
     *
     * Example 2:
     *
     * n - 10
     * stock data - 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     * q   - 1, 10, 5, 6, 4, 3, 8, 9
     * O/P: -1, 9, 4, 5, 3, 2, 7, 8
     *
     * Example 3:
     *
     * n - 10
     * stock data - 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
     * q  -> 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
     * O/P:  2, 3, 4, 5, 6, 7, 8, 9, 10, -1, 1
     *
     * Example 4:
     * n - 16
     * stock data - 5, 6, 7, 8, 9, 10, 10, 10, 12, 1, 2, 5, 4, 3, 2, 1
     * q -> 8, 9, 7, 2555, 13, 14, 11, 10
     * O/P: 10, 8, 5, 1, 14, 15, 10, -1
     *
     * Example 5:
     * n - 3
     * stock data - 5, 4, 5, 2
     * q -> 1, 2, 3,  4
     * O/P: 2, 4, 2, -1
     *
     * Example 6:
     * n - 5
     * stock data - 2, 5, 4, 5, 1
     * q -> 1, 2, 3, 4, 5
     * O/P: 5, 1, 1, 3, -1
     *
     * Example 7:
     * n - 6
     * stock data - 10, 10, 10, 4, 10, 10
     * q -> 1, 2, 3, 4, 5, 6
     * O/P: 4, 4, 4,-1, 4, 4
     */

    /**
     * Approach:
     * <p>
     * Combinations:
     * 1. Array in ASC sorted order
     * 2. Array in DESC sorted order
     * 3. All values are equal
     * 4. stock data[i] has peaks on either sides
     * 5. stock data[i] has peaks on either sides and lower values either to right or left
     * 6. stock data[i] has dips on either sides
     * 7. stock data[i] has dips on either sides and lower values either to right or left
     * 6. stock data[i] is equal to stock data[i - 1] and stock data[i + 1]
     */

    static public Integer getPrice(List<Integer> stockData, Integer q, Integer minValue, Integer maxValue) {
        if (q < 0 || q >= stockData.size()) return 0;

        if (minValue.equals(maxValue) || stockData.get(q).equals(minValue)) {
            // all values are equal or q is already the lowest
            return -1;
        }

        if ((q > 0 && stockData.get(q - 1) < stockData.get(q))) {
            return q - 1; // returning q cause we had to return (q - 1) + 1
        }

        if (q < stockData.size() - 1 && stockData.get(q + 1) < stockData.get(q)) {
            return q + 1; // returning q + 2 cause we had to return
        }

        int rightMinResult = stockData.get(q), rightMinIdx = Integer.MAX_VALUE;
        for (int j = q + 1; j < stockData.size(); ++j) {
            if (stockData.get(j) < rightMinResult) {
                rightMinIdx = j;
                rightMinResult = stockData.get(j);
                break;
            }
        }

        int leftMinResult = stockData.get(q), leftMinIdx = Integer.MAX_VALUE;
        for (int j = q - 1; j >= 0; --j) {
            if (stockData.get(j) < leftMinResult) {
                leftMinIdx = j;
                leftMinResult = stockData.get(j);
                break;
            }
        }

        if(leftMinResult == rightMinResult) return leftMinIdx;
        int leftDistance = leftMinIdx == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.abs(q - leftMinIdx);
        int rightDistance = rightMinIdx == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.abs(q - rightMinIdx);
        if(rightDistance == leftDistance) {
            if(leftDistance != Integer.MAX_VALUE) return leftMinIdx;
            return -1;
        }
        if(leftDistance < rightDistance) return leftMinIdx;
        return rightMinIdx;
    }

    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        // Write your code here
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        for (Integer stockDatum : stockData) {
            minValue = Math.min(minValue, stockDatum);
            maxValue = Math.max(maxValue, stockDatum);
        }
        List<Integer> output = new ArrayList<>();
        for (int q : queries) {
            q--; // Because q starts from 1 and stockData starts from 0
            Integer r = getPrice(stockData, q, minValue, maxValue);
            output.add(r == -1 ? -1 : r + 1);
        }
        return output;
    }

    public static void execute(Integer[] a, Integer[] q, Integer[] expO) {
        List<Integer> stockData = Arrays.asList(a);
        List<Integer> queries = Arrays.asList(q);
        List<Integer> exp = Arrays.asList(expO);
        System.out.println("s: " + stockData);
        System.out.println("q: " + queries);
        List<Integer> answer = predictAnswer(stockData, queries);
        System.out.println("a: " + answer);
        System.out.println("e: " + exp);
        System.out.println(answer.equals(exp));
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] q = new Integer[]{1, 10, 5, 6, 4, 3, 8, 9};
        Integer[] exp = new Integer[]{-1, 9, 4, 5, 3, 2, 7, 8};
        execute(a, q, exp);

        a = new Integer[]{5, 6, 8, 4, 9, 10, 8, 3, 6, 4};
        q = new Integer[]{6, 5, 4};
        exp = new Integer[]{5, 4, 8};
        execute(a, q, exp);

        a = new Integer[]{89214, 26671, 75144, 32445, 13656, 66289, 21951, 10265, 59857, 59133, 63227, 86121, 37411, 54628, 25859, 43510,
                63756, 54763, 30852, 53243, 76238, 96885, 33074, 17745, 81814, 43436, 79172, 92819, 30001, 68442, 54021, 35566,
                95113, 29164, 84362, 25120, 11804, 6313, 51736, 71661, 81797, 14962, 57781, 35560, 85941, 99991, 95421, 66048,
                54754, 26272, 35642, 47343, 39508, 85068, 65087, 21321, 28503, 60611, 30491, 58503, 29052, 84512, 94069, 40516,
                13675, 78430, 65635, 25479, 1094, 17370, 13491, 99243, 48683, 71271, 34802, 34624, 87613, 46574, 671, 42366, 89197,
                36313, 89708, 28704, 21380, 54795, 66376, 49882, 15405, 96867, 24737, 60808, 81378, 35157, 1324, 11404, 29938,
                66958, 53234, 47384};
        q = new Integer[]{80, 24, 26, 62, 46, 79, 85, 59, 52, 8, 76, 48, 72, 84, 3, 3, 30, 30, 36, 86, 96, 72, 93, 25,
                28, 68, 81, 18, 78, 14, 1, 57, 90, 26, 18, 87, 56, 55, 97, 59, 62, 73, 58, 85, 8, 60, 87, 89, 89, 22};
        exp = new Integer[]{79, 37, 24, 61, 45, -1, 89, 57, 51, 38, 79, 49, 71, 85, 2, 2, 29, 29, 37, 85, 95, 71, 92, 24,
                27, 69, 80, 19, 79, 13, 2, 56, 89, 24, 19, 86, 65, 56, 96, 57, 61, 71, 57, 89, 38, 59, 86, 95, 95, 21};
        execute(a, q, exp);

        a = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        q = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        exp = new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10, -1, 1};
        execute(a, q, exp);

        a = new Integer[]{5, 6, 7, 8, 9, 10, 10, 10, 12, 1, 2, 5, 4, 3, 2, 1};
        q = new Integer[]{8, 9, 7, 2555, 13, 14, 11, 10};
        exp = new Integer[]{10, 8, 5, 1, 14, 15, 10, -1};
                      //a: [10, 8, 10, 1, 14, 15, 10, -1]
        execute(a, q, exp);

        a = new Integer[]{5, 4, 5, 2};
        q = new Integer[]{1, 2, 3, 4};
        exp = new Integer[]{2, 4, 2, -1};
        execute(a, q, exp);

        a = new Integer[]{2, 5, 4, 5, 1};
        q = new Integer[]{1, 2, 3, 4, 5};
        exp = new Integer[]{5, 1, 1, 3, -1};
        execute(a, q, exp);

        a = new Integer[]{10, 10, 10, 4, 10, 10};
        q = new Integer[]{1, 2, 3, 4, 5, 6};
        exp = new Integer[]{4, 4, 4, -1, 4, 4};
        execute(a, q, exp);
    }

}
