package com.hitesh.test.cache;

import com.hitesh.test.cache.evictionpolicy.BaseEvictionPolicy;
import com.hitesh.test.datastore.BaseDataStore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cache {

    private CacheConfiguration cacheConfiguration;

    private BaseEvictionPolicy evictionPolicy;

    private BaseDataStore dataStore;

    public Cache(CacheConfiguration cacheConfiguration, BaseDataStore dataStore, BaseEvictionPolicy evictionPolicy) {

        log.info("Initialise fCache with configuration {}", cacheConfiguration.toString());

        this.cacheConfiguration = cacheConfiguration;

        this.dataStore = dataStore;
        this.evictionPolicy = evictionPolicy;

    }

    public boolean isFull() {
        return dataStore.getSize() >= cacheConfiguration.getCacheSize();
    }

    public void put(String key, Object value) {

        log.info("Begin put for key {}", key);

        if(isFull()) {
            evictionPolicy.evict();

            if(isFull()) {
                throw new RuntimeException("Invalid eviction policy!");
            }
        }

        evictionPolicy.onPut(key, value);

        dataStore.upsert(key, value);

        log.info("End put for key {}", key);
    }

    public Object get(String key) {
        log.info("get for key {}", key);
        evictionPolicy.onRead(key);
        return dataStore.read(key);
    }

    public void remove(String key) {

        log.info("Begin remove for key {}", key);

        evictionPolicy.onRemove(key);
        dataStore.delete(key);

        log.info("End remove for key {}", key);
    }

    public Double getHitRatio() {
        return evictionPolicy.getHitRatio();
    }

}
