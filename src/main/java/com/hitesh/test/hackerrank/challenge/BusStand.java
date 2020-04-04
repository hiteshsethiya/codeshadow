package com.hitesh.test.hackerrank.challenge;

import java.util.List;

public class BusStand {

    /*
     * 3. Bus Stand 
     * There are n people standing in a queue for bus numbered from left to right,
     * 1 to n. Each person has a patience limit,
     * p and will only wait until the time p expires. If the bus reaches after time p,
     * the person will leave the queue and miss the bus. Initially the bus is empty and has a fixed capacity,
     * k. Given a number of queries q,
     * where each query is a time of bus arrival,
     * q[i],
     * for each query,
     * print the index/number (1-indexed) of the kth person who catches the bus. If all passengers remaining in the queue can board the bus,
     * return 0 because there will be no kth person. For example,
     * given a bus size k=2,
     * patience limits of p=[1,2,3,4],
     * and queries at times q=[1,3,4],
     * there are three scenarios all dealing with the same initial queue. Where the bus arrives at q[0]=1,
     * all passengers are still queued but only the first two will fit on the bus. The last passenger who will fit is number 2. If the bus arrives at q[1]=3,
     * passengers 1and 2have left the queue,
     * the first two remaining (3 and 4) get on the bus,
     * filling it to capacity. When q[2]=4,
     * passengers 1,
     * 2and 3have left,
     * so passenger 4can get on. Since the bus is not filled,
     * there is no kthpassenger . The returned array of answers is [2,4,0]. Function Description Complete the function kthPerson in the editor below. The function must return an array of integers where each integer irepresents the results of a query,
     * q[i]. kthPerson has the following parameter(s): k: an integer that represents the size of the bus p[p[0],
     * ...p[n-1]]: an array of integers that represents the patience of n people from left to right q[q[0],
     * ...q[j-1]]: an array of integers that represents the queries containing times q[i] of the arrival of the bus Constraints 0 n,
     * k,
     * q[i],
     * p[i],
     * q[j] ≤ 100000 Input Format For Custom Testing The first line contains the capacity of the bus,
     * k. The second line contains the number of people in the queue,
     * n. The following n lines contain a single integer that represents the patience limit,
     * p of each person. The next line contains the number of queries,
     * j. The following j lines contain single integers that represents the time,
     * q[j] of bus arrival. Sample Case 0 Sample Input For Custom Testing 3 3 2 5 3 2 1 5 Sample Output 3 0 Explanation In the first query,
     * the bus arrives at time 1,
     * so all three people can catch the bus and fill it to capacity. The last person who catches the bus is 3. In the second query,
     * the bus arrives at time 5. By this time first and the third person already leave the queue. So,
     * only the second person can catch the bus. As the bus is not full,
     * the answer is 0. Sample Case 1 Sample Input For Custom Testing 2 7 1 4 4 3 1 2 6 7 1 2 3 4 5 6 7 Sample Output 2 3 3 3 0 0 0 Explanation In this case,
     * k=2,
     * p=[1,4,4,3,1,2,6] and q=[1,2,3,4,5,6,7]. In q[0],
     * the bus arrives at time 1,
     * so person number 2 will be the last person to catch the bus. In q[1],
     * the bus arrives at time 2,
     * so person number 3 will be the last person to catch the bus as k=2 and the person number 1 will already have expired his patience by then. In q[2],
     * the bus arrives at time 3,
     * so person number 3 will be the last person to catch the bus as k=2 and the person number 1 will already have expired his patience by then. In q[3],
     * the bus arrives at time 4,
     * so person number 3 will be the last person to catch the bus as k=2 and the person number 1 will already have expired his patience by then. In q[4],
     * the bus arrives at time 5,
     * everyone except the last person would have expired their patience. Hence,
     * only 1 person boards the bus,
     * it does not meet capacity so the answer is 0. And so on for q[5] and q[6].
     */

    public static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q) {
        // Write your code here
        return null;
    }

}
