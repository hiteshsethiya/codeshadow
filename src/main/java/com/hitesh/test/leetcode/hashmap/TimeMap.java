package com.hitesh.test.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    private final Map<String, TreeMap<Integer, String>> timeCache;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        this.timeCache = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.timeCache.computeIfAbsent(
            key, k -> new TreeMap<>()
        );
        this.timeCache.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeSeries = this.timeCache.get(key); 
        if(timeSeries == null) return "";
        String value = timeSeries.get(timestamp); 
        if(value != null) return value;
        Map.Entry<Integer, String> lowerBound = timeSeries.lowerEntry(timestamp);
        return lowerBound == null ? "" : lowerBound.getValue();
    }
}

