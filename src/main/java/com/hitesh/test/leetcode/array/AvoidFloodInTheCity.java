package com.hitesh.test.leetcode.array;

import java.util.*;

public class AvoidFloodInTheCity {

    /*
     * Your country has an infinite number of lakes. Initially, all the lakes are empty,
     * but when it rains over the nth lake, the nth lake becomes full of water.
     * If it rains over a lake which is full of water, there will be a flood.
     * Your goal is to avoid the flood in any lake.
     *
     * Given an integer array rains where:
     *
     * rains[i] > 0 means there will be rains over the rains[i] lake.
     * rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
     * Return an array ans where:
     *
     * ans.length == rains.length
     * ans[i] == -1 if rains[i] > 0.
     * ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
     * If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
     *
     * Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake,
     * nothing changes. (see example 4)
     *
     *
     *
     * Example 1:
     *
     * Input: rains = [1,2,3,4]
     * Output: [-1,-1,-1,-1]
     * Explanation: After the first day full lakes are [1]
     * After the second day full lakes are [1,2]
     * After the third day full lakes are [1,2,3]
     * After the fourth day full lakes are [1,2,3,4]
     * There's no day to dry any lake and there is no flood in any lake.
     * Example 2:
     *
     * Input: rains = [1,2,0,0,2,1]
     * Output: [-1,-1,2,1,-1,-1]
     * Explanation: After the first day full lakes are [1]
     * After the second day full lakes are [1,2]
     * After the third day, we dry lake 2. Full lakes are [1]
     * After the fourth day, we dry lake 1. There is no full lakes.
     * After the fifth day, full lakes are [2].
     * After the sixth day, full lakes are [1,2].
     * It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
     * Example 3:
     *
     * Input: rains = [1,2,0,1,2]
     * Output: []
     * Explanation: After the second day, full lakes are  [1,2]. We have to dry one lake in the third day.
     * After that, it will rain over lakes [1,2]. It's easy to prove that no matter which lake you choose
     * to dry in the 3rd day, the other one will flood.
     * Example 4:
     *
     * Input: rains = [69,0,0,0,69]
     * Output: [-1,69,1,1,-1]
     * Explanation: Any solution on one of the forms [-1,69,x,y,-1], [-1,x,69,y,-1] or [-1,x,y,69,-1]
     * is acceptable where 1 <= x,y <= 10^9
     * Example 5:
     *
     * Input: rains = [10,20,20]
     * Output: []
     * Explanation: It will rain over lake 20 two consecutive days. There is no chance to dry any lake.
     *
     *
     * Constraints:
     *
     * 1 <= rains.length <= 10^5
     * 0 <= rains[i] <= 10^9
     */

    private static final int[] EMPTY = new int[0];

    public int[] avoidFloodBF(int[] rains) {
        int[] ans = new int[rains.length];
        Set<Integer> full = new HashSet<>();
        int n = rains.length;
        for (int i = 0; i < n; ++i) {
            int j = i + 1;
            if (j < n && rains[i] > 0 && rains[i] == rains[j]) return EMPTY;
            if (full.contains(rains[i])) return EMPTY;
            if (rains[i] > 0) {
                ans[i] = -1;
                full.add(rains[i]);
            } else if (rains[i] == 0) {
                while (j < n && (rains[j] == 0 || !full.contains(rains[j]))) {
                    j++;
                }
                if (j < n) {
                    ans[i] = full.contains(rains[j]) ? rains[j] : 1;
                    full.remove(ans[i]);
                } else {
                    ans[i] = 1;
                }
            }
        }
        return ans;
    }

    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        int n = rains.length;
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> noRains = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            if (rains[i] == 0) {
                noRains.add(i);
                ans[i] = 1;
            } else if (rains[i] > 0) {
                if (fullLakes.containsKey(rains[i])) {
                    Integer canDry = noRains.ceiling(fullLakes.get(rains[i]));
                    if (canDry == null) return EMPTY;
                    ans[canDry] = rains[i];
                    noRains.remove(canDry);
                }
                fullLakes.put(rains[i], i);
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void execute(int[] input, int[] ans) {
        int[] o = new AvoidFloodInTheCity().avoidFlood(input);
        System.out.println(Arrays.toString(o));
        System.out.println(Arrays.equals(o, ans));
    }

    public static void main(String[] args) {
        execute(new int[]{1, 2, 0, 2, 3, 0, 1}, new int[]{-1, -1, 2, -1, -1, 1, -1});
        execute(new int[]{1, 0, 2, 0, 2, 1}, new int[]{-1, 1, -1, 2, -1, -1});
        execute(new int[]{1, 2, 3, 4}, new int[]{-1, -1, -1, -1});
        execute(new int[]{1, 2, 0, 0, 2, 1}, new int[]{-1, -1, 2, 1, -1, -1});
        execute(new int[]{1, 2, 0, 1, 2}, new int[]{});
        execute(new int[]{69, 0, 0, 0, 69}, new int[]{-1, 69, 1, 1, -1});
        execute(new int[]{10, 20, 20}, new int[]{});
    }

}
