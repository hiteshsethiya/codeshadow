package com.hitesh.test.datastore;

public interface BaseDataStore {

    //Insert or update based on the existence of the key
    void upsert(String key, Object value);

    void delete(String key);

    Object read(String key);

    int getSize();

}
