package com.hitesh.test.cache.evictionpolicy;

import com.hitesh.test.cache.CacheConfiguration;
import com.hitesh.test.datastore.BaseDataStore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class LRUEvictionPolicy extends BaseEvictionPolicy {

    private int maxReadCount = 0;
    private double hitRatio;
    private int totalSuccessfulHits;
    private int totalReferences;

    private static Deque<KeyMetadata> LRU_QUEUE;

    private static Map<String, KeyMetadata> KEY_METADATA_MAP = new ConcurrentHashMap<>();


    public LRUEvictionPolicy(BaseDataStore baseDataStore, CacheConfiguration cacheConfiguration) {
        super(baseDataStore, cacheConfiguration);
        LRU_QUEUE = new LinkedList<>();
    }

    private KeyMetadata getLeastReadKey() {
        KeyMetadata key = null;
        if (LRU_QUEUE.isEmpty()) {
            return null;
        } else {
            int min = Integer.MAX_VALUE;
            for (KeyMetadata iKeyMetadata : LRU_QUEUE) {
                if (iKeyMetadata.getReadCount() < min) {
                    key = iKeyMetadata;
                }
            }
        }
        return key;
    }

    @Override
    public void evict() {

        if (LRU_QUEUE.isEmpty()) return;
        KeyMetadata evictKey = getLeastReadKey();

        if (evictKey == null) {
            log.info("No key to evict!");
        } else {
            LRU_QUEUE.removeFirstOccurrence(evictKey);
            getBaseDataStore().delete(evictKey.getKey());
            removeKeyMetadata(evictKey.getKey());
        }
    }

    @Override
    public void onPut(String key, Object value) {

        KeyMetadata keyMetadata = getKeyMetadata(key);
        if (keyMetadata == null) {
            keyMetadata = createNew(key);
        }

        LRU_QUEUE.addLast(keyMetadata);
    }

    @Override
    public void onRead(String key) {

        ++totalReferences;
        if (getBaseDataStore().read(key) != null) {

            KeyMetadata keyMetadata = getKeyMetadata(key);

            hitRatio = (double) ++totalSuccessfulHits / (double) totalReferences;

            keyMetadata.read();
            if (keyMetadata.getReadCount() > maxReadCount) {

                if (!keyMetadata.equals(LRU_QUEUE.getFirst())) {
                    LRU_QUEUE.removeFirstOccurrence(key);
                    LRU_QUEUE.addFirst(keyMetadata);
                }

                maxReadCount = keyMetadata.getReadCount();
            }

        } else {
            totalSuccessfulHits = Math.max(0, --totalSuccessfulHits);
            hitRatio = (double) totalSuccessfulHits / (double) totalReferences;
        }
    }

    @Override
    public void onRemove(String key) {
        LRU_QUEUE.removeFirstOccurrence(key);
        removeKeyMetadata(key);
    }

    @Override
    public Double getHitRatio() {
        return hitRatio;
    }

    private KeyMetadata getKeyMetadata(String key) {
        return KEY_METADATA_MAP.getOrDefault(key, null);
    }

    private KeyMetadata removeKeyMetadata(String key) {
        return KEY_METADATA_MAP.remove(key);
    }

    private KeyMetadata createNew(String key) {
        KeyMetadata newKeyMetadata = KeyMetadata.builder()
                .key(key)
                .readCount(0)
                .isDeleted(false)
                .build();
        KEY_METADATA_MAP.put(key, newKeyMetadata);
        return newKeyMetadata;
    }

    @Getter
    @Setter
    @Builder
    public static class KeyMetadata {
        private String key;
        private Integer readCount;
        private boolean isDeleted;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyMetadata that = (KeyMetadata) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public synchronized void read() {
            ++readCount;
        }

    }
}

