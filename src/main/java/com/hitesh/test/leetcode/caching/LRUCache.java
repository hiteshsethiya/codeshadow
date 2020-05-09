package com.hitesh.test.leetcode.caching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    /*
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * Example:
     *
     * LRUCache cache = new LRUCache(2);
     *  cache.put(1,1);
     *  cache.put(2,2);
     * cache.get(1);)       // returns 1
     *  cache.put(3,3);    // evicts key 2
     * cache.get(2);)       // returns -1 (not found)
     *  cache.put(4,4);    // evicts key 1
     * cache.get(1);)       // returns -1 (not found)
     * cache.get(3);)       // returns 3
     * cache.get(4);)       // returns 4
     */

    final Map<Integer, Tuple> cache;
    final LinkedList<Tuple> lru;
    final int capacity;

    static class Tuple {
        private int key;
        private int value;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return key == tuple.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lru = new LinkedList<>();
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Tuple k = cache.get(key);
            lru.remove(k);
            lru.addLast(k);
            return k.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!this.cache.containsKey(key) && this.lru.size() == this.capacity) {
            evict();
        }
        if (this.cache.containsKey(key)) {
            Tuple k = this.cache.get(key);
            lru.remove(k);
            lru.addLast(k);
            k.value = value;
        } else {
            Tuple k = new Tuple();
            k.key = key;
            k.value = value;
            this.cache.put(key, k);
            this.lru.addLast(k);
        }
    }

    private void evict() {
        if (!this.lru.isEmpty()) {
            this.cache.remove(this.lru.removeFirst().key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        /*
         * ["LRUCache","put","put","put","put","get","get"]
         * [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
         */
        cache = new LRUCache(2 /* capacity */);
        cache.put(2, 1);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}
