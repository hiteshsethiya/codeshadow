package com.hitesh.test.datastore;

import com.hitesh.test.enums.DataStore;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static com.hitesh.test.enums.DataStore.MEMORY_MAP;

@Slf4j
public class DataStoreFactory {

    private MapDataStore mapDataStore;

    private static final Map<DataStore, BaseDataStore> DATA_STORES = new HashMap<>();

    public DataStoreFactory() {
        DATA_STORES.put(MEMORY_MAP, new MapDataStore());
    }

    public BaseDataStore getDataStore(DataStore dataStore) {

        BaseDataStore store = DATA_STORES.get(dataStore);

        if (store == null) {
            throw new RuntimeException("No such data store " + dataStore);
        }
        return store;
    }

}
