package com.hitesh.test.codility.amz;

import java.util.*;

public class PopularNFeatures {

    public static String getCleansedString(String str) {
        return str.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static class Feature implements Comparable<Feature> {
        public String name;
        public int frequency;

        public Feature () {
        }
        public Feature (String name, int frequency) {
            this.name = name;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Feature b) {
            if(this.frequency == b.frequency) {
                return this.name.compareTo(b.name);
            }
            return Integer.compare(b.frequency, this.frequency);
        }
    }

    static public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        ArrayList<String> topKFeatures = new ArrayList<>();
        // WRITE YOUR CODE HERE
        if(numFeatures <= 0 || topFeatures <= 0 || numFeatureRequests <= 0) return topKFeatures;

        for(int i = 0; i < possibleFeatures.size(); ++i) {
            possibleFeatures.set(i, getCleansedString(possibleFeatures.get(i)));
        }

        Map<String,Feature> featureMap = new HashMap<>();

        for(String i : featureRequests) {
            String[] words = i.split(" ");
            Set<String> wordSet = new HashSet<>();
            for(String iWord : words) {
                wordSet.add(getCleansedString(iWord));
            }
            for(String iFeature : possibleFeatures) {
                if(wordSet.contains(iFeature)) {
                    featureMap.computeIfAbsent(iFeature, k -> new Feature(iFeature, 0)).frequency++;
                    wordSet.remove(iFeature); // Since it has to be considered only once.
                }
            }
        }

        if(featureMap.isEmpty()) return topKFeatures;

        PriorityQueue<Feature> featureMaxHeap = new PriorityQueue<>(featureMap.size());
        featureMaxHeap.addAll(featureMap.values());
        for(int i = 0; i < topFeatures && !featureMaxHeap.isEmpty(); ++i) {
            topKFeatures.add(featureMaxHeap.poll().name);
        }
        return topKFeatures;
    }

    public static void main(String[] args) {
        String[] featureRequests = new String[] {"storage, bc", "storage! af", "board asdf", "board qwerty qwerty"};
        String[] possibleFeatures = new String[] {"storage", "board", "qwerty", "asdfa"};
        System.out.println(popularNFeatures(
                6,5,
                Arrays.asList(possibleFeatures),
                3,
                Arrays.asList(featureRequests)
        ));
    }

}
