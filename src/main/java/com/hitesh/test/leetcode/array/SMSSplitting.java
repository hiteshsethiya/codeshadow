package com.hitesh.test.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SMSSplitting {

    public static String getSegmentStr(int s, int t) {
        return "(" + s + "/" + t + ")";
    }

    public static List<String> segments(String message) {
        if (message == null || message.isEmpty()) return new ArrayList<>();
        message = message.trim();
        String[] w = message.split(" ");
        int segs = 0;
        List<String> segments = new ArrayList<>();

        StringBuilder si = new StringBuilder();
        for (int i = 0; i < w.length; ++i) {
            String word = w[i];
            if ((si.length() + word.length()) > 155) {
                segments.add(si.toString());
                si = new StringBuilder();
            }
            si.append(word);
            if (si.length() >= 155) {
                segments.add(si.toString());
                si = new StringBuilder();
            }
            if (i < w.length - 1) {
                si.append(" ");
            }
        }

        if (si.length() < 160 && !si.toString().trim().isEmpty()) {
            segments.add(si.toString());
        }

        segs = segments.size();

        if(segs > 1) {
            for (int i = 1; i <= segs; ++i) {
                segments.set(i - 1, segments.get(i - 1) + getSegmentStr(i, segs));
            }
        }
        return segments;
    }

    public static void printList(List<String> s) {
        StringBuilder a = new StringBuilder();
        s.forEach(a::append);
        System.out.println(a);
    }

    public static void main(String[] args) {
        String m = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus";
        printList(segments(m));
        m = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id tristique quam, in ullamcorper metus. Duis lacinia dolor non quam porta, non turpis duis.";
        printList(segments(m));
        m = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.";
        printList(segments(m));
//      m = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus consequat nec dui quis maximus. Praesent vehicula feugiat condimentum. Nunc porta vulputate elit sit amet lacinia. Vivamus volutpat accumsan consequat. Nulla mattis odio erat, vel convallis neque semper nec. Integer a pharetra purus";
        printList(segments(m));
        m = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus consequat nec dui quis maximus. Praesent vehicula feugiat condimentum. Nunc portamludimi vulputate elit sit amet lacinia. Vivamus volutpat accumsan consequat. Nulla mattis odio erat, vel convallis neque semper nec. Integer a pharetra purus";
        printList(segments(m));
        m = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        printList(segments(m));
    }


}
