package com.hitesh.test.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    /*
     * In a row of trees, the i-th tree produces fruit with type tree[i].
     *
     * You start at any tree of your choice, then repeatedly perform the following steps:
     *
     * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
     * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
     * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
     *
     * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
     *
     * What is the total amount of fruit you can collect with this procedure?
     *
     *
     *
     * Example 1:
     *
     * Input: [1,2,1]
     * Output: 3
     * Explanation: We can collect [1,2,1].
     * Example 2:
     *
     * Input: [0,1,2,2]
     * Output: 3
     * Explanation: We can collect [1,2,2].
     * If we started at the first tree, we would only collect [0, 1].
     * Example 3:
     *
     * Input: [1,2,3,2,2]
     * Output: 4
     * Explanation: We can collect [2,3,2,2].
     * If we started at the first tree, we would only collect [1, 2].
     * Example 4:
     *
     * Input: [3,3,3,1,2,1,1,2,3,3,4]
     * Output: 5
     * Explanation: We can collect [1,2,1,1,2].
     * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
     *
     *
     * Note:
     *
     * 1 <= tree.length <= 40000
     * 0 <= tree[i] < tree.length
     */

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> window = new HashMap<>();
        int i = 0, j = 0, fruitAmount = 0;
        for(; j < tree.length; ++j) {
            window.put(tree[j], window.getOrDefault(tree[j], 0) + 1);
            if(window.size() > 2) {
                window.put(tree[i], window.getOrDefault(tree[i], 0) - 1);
                window.remove(tree[i++], 0);
            }
            fruitAmount = Math.max(fruitAmount, j - i + 1);
        }
        return fruitAmount;
    }

    public static void execute(int[] input, int ans) {
        int o = new FruitIntoBaskets().totalFruit(input);
        System.out.println(o);
        System.out.println(o == ans);
    }

    public static void main(String[] args) {
        execute(new int[] {1,0,1,4,1,4,1,2,3}, 5);
        execute(new int[] {0}, 1);
        execute(new int[] {0,1,2,3,4,5}, 2);
        execute(new int[] {1,2,1}, 3);
        execute(new int[] {0,1,2,2}, 3);
        execute(new int[] {1,2,3,2,2}, 4);
        execute(new int[] {3,3,3,1,2,1,1,2,3,3,4}, 5);
    }

}
