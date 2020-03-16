package com.hitesh.test;

import com.hitesh.test.cache.CacheConfiguration;
import com.hitesh.test.cache.FCache;
import com.hitesh.test.enums.DataStore;
import com.hitesh.test.enums.EvictionPolicy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Driver {

    public static void main(String[] args) {

        CacheConfiguration cacheConfiguration = new CacheConfiguration(
                EvictionPolicy.LRU,
                DataStore.MEMORY_MAP,
                10
        );
        
        FCache fCache = new FCache(cacheConfiguration);

        fCache.put("key1", "value1");
        fCache.put("key2", "value2");
        fCache.put("key3", "value3");
        fCache.put("key4", "value4");
        fCache.put("key5", "value5");
        fCache.put("key6", "value6");
        fCache.put("key7", "value7");
        fCache.put("key8", "value8");
        fCache.put("key9", "value9");
        fCache.put("key10", "value10");

        log.info("" + fCache.get("key10"));
        log.info("" + fCache.isFull());

        fCache.put("key11", "value11");
        fCache.remove("key1");
        fCache.remove("key123");

        log.info("" + fCache.get("key123"));
        log.info("" + fCache.getHitRatio());

        log.info("Completed");
    }

}
