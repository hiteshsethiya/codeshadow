package com.hitesh.test.leetcode.string;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NextClosestTime {

    /*
     * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
     * There is no limit on how many times a digit can be reused.
     *
     * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34",
     * "12:9" are all invalid.
     *
     * Example 1:
     *
     * Input: "19:34"
     * Output: "19:39"
     * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.
     * It is not 19:33, because this occurs 23 hours and 59 minutes later.
     *
     * Example 2:
     *
     * Input: "23:59"
     * Output: "22:22"
     * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
     * It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
     */

    // B has to be greater than A for a +ve diff
    public int getTimeDiffInMinutes(Integer hourA, Integer minuteA, Integer hourB, Integer minuteB) {
        int aMinutes = (hourA * 60) + minuteA;
        int bMinutes = (hourB * 60) + minuteB;
        return bMinutes - aMinutes;
    }

    public boolean isValidMinute(int min) {
        return 0 <= min && min <= 59;
    }

    public boolean isValidHour(int hour) {
        return 0 <= hour && hour <= 23;
    }

    public String getTime(Integer hour, Integer minute) {
        return (hour < 10 ? ("0" + hour) : hour) + ":" + (minute < 10 ? ("0" + minute) : minute);
    }

    public String nextClosestTime(String time) {
        if (time == null || time.isEmpty() || "00:00".equals(time)) return time;

        Set<Integer> minutes = new HashSet<>();
        Set<Integer> hours = null;
        String minTime = "";
        int minDiff = Integer.MAX_VALUE;
        String cleanTime = time.replace(":", "");
        int n = cleanTime.length();
        Integer startHour = 0, startMinute = 0;
        int intTime = Integer.parseInt(cleanTime);
        startHour = intTime / 100;
        startMinute = intTime % 100;

        for (int i = 0; i < n; ++i) {
            if (cleanTime.charAt(i) - '0' > 5) continue;
            for (int j = 0; j < n; ++j) {
                int minute = Integer.parseInt((cleanTime.charAt(i) - '0') + "" + (cleanTime.charAt(j) - '0'));
                if (isValidMinute(minute)) {
                    minutes.add(minute);
                }
            }
        }
        if(minutes.size() == 1) return time;
// Have all possible valid minute combinations
// filter the hours from it
        hours = minutes.stream().filter(this::isValidHour).collect(Collectors.toSet());
        int negDiff = Integer.MAX_VALUE;
        String negTime = "";
        for (Integer iHour : hours) {
            for (Integer iMinute : minutes) {
                int diff = getTimeDiffInMinutes(startHour, startMinute, iHour, iMinute);
                if (diff > 0 && diff <= minDiff) {
                    minTime = getTime(iHour, iMinute);
                    minDiff = diff;
                } else if(diff != 0 && diff < negDiff) {
                    negDiff = diff;
                    negTime = getTime(iHour, iMinute);
                }
            }
        }
        return minTime.isEmpty() ? negTime : minTime;
    }

    public static void execute(String input, String ans) {
        String output = new NextClosestTime().nextClosestTime(input);
        System.out.println(output);
        System.out.println(output.equals(ans));
    }

    public static void main(String[] args) {
        execute("11:11", "11:11");
        execute("23:59", "22:22");
        execute("22:59", "22:22");
        execute("21:59", "22:11");
        execute("19:34", "19:39");
        execute("01:00", "01:01");
        execute("00:59", "05:00");
        execute("00:01", "00:10");
        execute("00:30", "00:33");
        execute("20:14", "20:20");
    }

}
