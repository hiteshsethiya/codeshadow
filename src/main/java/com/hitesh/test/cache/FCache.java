package com.hitesh.test.cache;

import com.hitesh.test.cache.evictionpolicy.BaseEvictionPolicy;
import com.hitesh.test.cache.evictionpolicy.EvictionFactory;
import com.hitesh.test.datastore.BaseDataStore;
import com.hitesh.test.datastore.DataStoreFactory;

public class FCache {

    private Cache cache;
    private DataStoreFactory dataStoreFactory;
    private EvictionFactory evictionFactory;

    public FCache(CacheConfiguration cacheConfiguration) {

        this.dataStoreFactory = new DataStoreFactory();
        this.evictionFactory = new EvictionFactory();

        BaseDataStore dataStore = dataStoreFactory.getDataStore(cacheConfiguration.getDataStore());
        BaseEvictionPolicy evictionPolicy = evictionFactory.createEvictionPolicy(
                cacheConfiguration.getEvictionPolicy(), cacheConfiguration, dataStore
        );

        cache = new Cache(cacheConfiguration,
                dataStore,
                evictionPolicy);
    }


    public boolean isFull() {
        return cache.isFull();
    }

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }

    public void remove(String key) {
        cache.remove(key);
    }

    public Double getHitRatio() {
        return cache.getHitRatio();
    }
}