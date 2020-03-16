package com.hitesh.test.g4gcourse.array.binarysearch;

import java.util.Arrays;

public class FindInSortedRotatedArray {

    static int findPivot(int[] a) {
        for (int l = 0, h = a.length - 1; l <= h; ) {
            int m = l + (h - l) / 2;
            if (l == h || a[m] > a[m + 1]) {
                if (l == a.length - 1 && h == a.length - 1) return -1;
                return m;
            }
            if (a[l] > a[m]) h = m - 1;
            else l = m + 1;
        }
        return -1;
    }

    static int searchWithDups(int[] a, int x) {
        return findPivotRecur(a, 0, a.length - 1, x);
    }

    static int findPivotRecur(int[] a, int l, int h, int x) {

        if (l == h) return l;
        if (l > h) return -1;
        int m = (l + h) >> 1;
        if(a[m] == x) return m;
        if (a[l] == a[m] && a[m] == a[h]) {
            ++l;
            --h;
        }

        if (a[l] <= a[m]) {
            if (a[l] <= x && x <= a[m]) {
                return findPivotRecur(a, l, m - 1, x);
            }
            return findPivotRecur(a, m + 1, h, x);
        }
        if (a[m] <= x && x <= a[h]) {
            return findPivotRecur(a, m + 1, h, x);
        }

        return findPivotRecur(a, l, m - 1, x);
    }

    static int bSearch(int[] a, int l, int h, int x) {
        if (l > h) return -1;
        int m = l + (h - l) / 2;
        if (a[m] == x) {
            return m;
        }
        if (x < a[m]) {
            return bSearch(a, l, m - 1, x);
        } else {
            return bSearch(a, m + 1, h, x);
        }
    }

    // returns index of the element or -1 if element doesn't exist
    public static int search(int[] nums, int target) {
        int rotate = findPivot(nums);
        if (rotate >= 0) {
            if (target == nums[rotate]) return rotate;
            return Math.max(bSearch(nums, 0, rotate - 1, target), bSearch(nums, rotate + 1, nums.length - 1, target));
        } else {
            return bSearch(nums, 0, nums.length - 1, target);
        }
    }

    public static boolean searchR(int[] nums, int target, int l, int h) {
        if(l > h) return false;
        int m = l + (h - l) / 2;
        if(nums[m] == target) return true;
        return searchR(nums, target, l, m - 1) || searchR(nums, target, m + 1, h);
    }

    public static boolean searchII(int[] nums, int target) {
        return searchR(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1};
        target = 2;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{2,5,6,0,0,1,2};
        target = 0;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{2,5,6,0,0,1,2};
        target = 3;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{4,5,6,7,0,1,2};
        target = 0;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{0,1,2,4,5,6,7};
        target = 0;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{10, 10, 10};
        target = 1;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a, target));
        a = new int[]{10, 10, 10};
        target = 10;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{10, 20, 3, 4, 5};
        target = 5;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{10, 20, 3, 4, 5};
        target = 3;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{10, 20, 3, 4, 5};
        target = 1;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a,target));
        a = new int[]{10, 20, 3, 4, 5};
        target = 1;
        System.out.println(Arrays.toString(a) + " " + target + " -> " + searchII(a, target));
        /*System.out.println(findPivot(new int[]{10, 20, 40,40,40,40, 50, 50, 60, 60, 7, 7, 8, 8}));
        System.out.println(findPivot(new int[]{10, 20, 40, 5, 6, 7, 8}));
        System.out.println(findPivot(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findPivot(new int[]{10, 20, 3, 4, 5}));
        System.out.println(findPivot(new int[]{10, 1, 3, 4, 5}));
        System.out.println(findPivot(new int[]{3, 4, 5, 20, 1}));
        System.out.println(findPivot(new int[]{10, 10, 10}));*/
    }

}
