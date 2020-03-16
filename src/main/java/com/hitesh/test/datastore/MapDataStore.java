package com.hitesh.test.datastore;



import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MapDataStore implements BaseDataStore {

    private Map<String, Object> DATA_STORE;

    public MapDataStore() {
        DATA_STORE = new ConcurrentHashMap<>();
    }

    @Override
    public void upsert(String key, Object value) {
        log.info("Begin insert for key {}", key);
        DATA_STORE.put(key, value);
        log.info("End insert for key {}", key);
    }

    @Override
    public void delete(String key) {
        log.info("Begin delete for key {}", key);
        DATA_STORE.remove(key);
        log.info("End delete for key {}", key);
    }

    @Override
    public Object read(String key) {
        log.info("read for key {}", key);
        return DATA_STORE.getOrDefault(key, null);
    }

    @Override
    public int getSize() {
        return DATA_STORE.keySet().size();
    }
}
