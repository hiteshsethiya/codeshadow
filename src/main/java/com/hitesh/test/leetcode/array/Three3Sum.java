package com.hitesh.test.leetcode.array;

import java.util.*;

public class Three3Sum {

    /*
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     *
     * The solution set must not contain duplicate triplets.
     *
     * Example:
     *
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     *
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */

    static public Set<List<Integer>> twoSum(int[] nums, int excludeI, int target) {
        Set<List<Integer>> output = new HashSet<>();
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = excludeI + 1; i < nums.length; ++i) {
            Integer iDiff = target - nums[i];
            if (idxMap.containsKey(iDiff)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[i]);
                pair.add(iDiff);
                output.add(pair);
            }
            idxMap.put(nums[i], idxMap.getOrDefault(nums[i], 0) + 1);
        }
        return output;
    }

    // 	Accepted	661 ms	46.9 MB	java
    static public List<List<Integer>> threeSumWithoutSorting(int[] nums) {
        Set<List<Integer>> output = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Set<List<Integer>> pairSum = twoSum(nums, i, -nums[i]);
            if (!pairSum.isEmpty()) {
                for (List<Integer> pair : pairSum) {
                    pair.add(nums[i]);
                    pair.sort(Integer::compareTo);
                    output.add(pair);
                }
            }
        }
        return new ArrayList<>(output);
    }

    // Accepted	26 ms	45.7 MB
    static public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> output = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            if(nums[i] > 0) break;
            int target = -nums[i];
            List<Integer> pairs = new ArrayList<>(3);
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    pairs.add(nums[i]);
                    pairs.add(nums[j]);
                    pairs.add(nums[k]);
                    output.add(pairs);
                    while(i < j && nums[i] == nums[i + 1]) ++i;
                    while(i < j && nums[j] == nums[j - 1]) --j;
                    ++j;
                    --k;
                    pairs = new ArrayList<>();
                } else if (sum > target) {
                    --k;
                }
                else {
                    ++j;
                }
            }
        }
        return new ArrayList<>(output);
    }


    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4, 0, 0};
        System.out.println(threeSum(a));
        a = new int[]{0,0,0,0};
        System.out.println(threeSum(a));
        a = new int[]{-2,0,1,1,2};
        System.out.println(threeSum(a));
    }


}
