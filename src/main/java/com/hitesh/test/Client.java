package com.hitesh.test;

import com.hitesh.test.cache.CacheConfiguration;
import com.hitesh.test.cache.FCache;
import com.hitesh.test.enums.DataStore;
import com.hitesh.test.enums.EvictionPolicy;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Please pass configuration!");
        }

        int size = Integer.parseInt(args[0]);
        String dataStore = args[1];
        String evictionPolicy = args[2];

        EvictionPolicy ePolicy = EvictionPolicy.valueOf(evictionPolicy);
        DataStore dStore = DataStore.valueOf(dataStore);

        CacheConfiguration cacheConfiguration = CacheConfiguration
                .builder()
                .cacheSize(size)
                .evictionPolicy(ePolicy)
                .dataStore(dStore)
                .build();

        FCache fCache = new FCache(cacheConfiguration);

        try (Scanner scanner = new Scanner(System.in)) {
            String command;
            while (scanner.hasNext()) {
                command = scanner.nextLine();
                parseCommand(command, fCache);
            }
        }
    }

    private static void parseCommand(String argument, FCache fCache) {

        String[] splitCommand = argument.trim().split(" ");

        String command = splitCommand[0].trim().toUpperCase();

        switch (command) {
            case "READ": {
                String key = splitCommand[1];
                if (key == null || key.isEmpty()) {
                    System.out.println("Key cannot be empty!");
                } else {
                    Object value = fCache.get(key);
                    if(value == null) {
                        System.out.println("Not found!");
                    } else {
                        System.out.println(value);
                    }
                }
            }
            break;

            case "PUT": {
                String key = splitCommand[1];
                String value = splitCommand[2];
                if (key == null || key.isEmpty()) {
                    System.out.println("Key cannot be empty!");
                } else {
                    fCache.put(key, value);
                    System.out.println("OK");
                }
            }
            break;

            case "REMOVE": {
                String key = splitCommand[1];
                if (key == null || key.isEmpty()) {
                    System.out.println("Key cannot be empty!");
                } else {
                    fCache.remove(key);
                    System.out.println("OK");
                }
            }
            break;

            case "HITS": {
                System.out.println(fCache.getHitRatio());
            }
            break;

            case "FULL": {
                System.out.println(fCache.isFull());
            }
            break;
        }
    }

}
