package com.hitesh.test.cache;

import com.hitesh.test.enums.DataStore;
import com.hitesh.test.enums.EvictionPolicy;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class CacheConfiguration {
    private EvictionPolicy evictionPolicy;
    private DataStore dataStore;
    private int cacheSize;
}
