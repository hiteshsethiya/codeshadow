package com.hitesh.test.g4gpractice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public static final List<String> MONTHS = Arrays.asList(
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec"
    );

    public static class Node implements Comparable<Node> {
        Integer value = 0;
        Integer count = 0;

        @Override
        public int compareTo(Node node) {

            int cC = this.count.compareTo(node.count);
            if(cC < 0) return cC;

            return this.value.compareTo(node.value);
        }
    }

    public static void main(String[] args) {

        System.out.println(formatDate("20th Oct 2052"));
        System.out.println(formatDate("2nd Oct 2052"));

        List<Integer> arr = new ArrayList<>();

        arr.add(4);
        arr.add(4);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(5);
        arr.add(5);
        arr.add(5);
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(7);
        arr.add(1);
        arr.add(8);
        arr.add(2);


        List<Node> nodes = new ArrayList<>(arr.size());

        for(Integer i : arr) {

            Node tNode = null;
            for(Node iNode: nodes) {
                if(iNode.value.equals(i)) {
                    tNode = iNode;
                    break;
                }
            }

            if(tNode == null) {
                tNode = new Node();
                tNode.value = i;
                tNode.count += 1;
                nodes.add(tNode);
            } else {
                tNode.count += 1;
            }
        }


        Node[] output = nodes.toArray(new Node[0]);
        Arrays.sort(output);
        for (Node e : output) {
            for(int i = 0; i < e.count; ++i) {
                System.out.println(e.value);
            }
        }

        /*for(int i = 0; i < nodes.size(); ++i) {
            Node e = nodes.poll();
            if(e == null) {
                continue;
            }
            for(int iE = 0; iE < e.count; iE++) {
                System.out.println(e.value);
            }
        }*/

        LinkedList<Integer> indexes = new LinkedList<>();
        indexes.addFirst(0);
    }

    public static String formatDate(String date) {
        String[] splitDates = date.split(" ");
        int month = (MONTHS.indexOf(splitDates[1]) + 1);
        String dayString = splitDates[0].substring(0, splitDates.length - 1);
        if(!(dayString.charAt(dayString.length() - 1) >= 48
        && dayString.charAt(dayString.length() - 1) <= 57)) {
            dayString = splitDates[0].substring(0, splitDates.length - 2);
        }
        int day = Integer.parseInt(dayString);
        return splitDates[2] + "-" +
                (month < 10 ? "0" + month : month)
                 + "-"
                + (day < 10 ? "0" + day : day);
    }

}
