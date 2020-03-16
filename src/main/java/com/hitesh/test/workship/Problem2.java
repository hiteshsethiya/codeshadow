package com.hitesh.test.workship;

import lombok.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem2 {

    /**
     * Input:
     * - Credit card transactions data with possible duplicates
     *
     * - System is getting one transaction record at a time, unordered
     *
     * - TransactionID, TransactionTime, <other transactional information>
     *
     *
     * Output:
     *
     * - Print whether UNIQUE or DUPLICATE record.
     *
     *
     * Purge policy:
     *
     * - To reduce memory requirements, you need to purge data older than 1 hour.
     *
     * - The purge function would be invoked once a minute.
     *
     * - Purge is based on transactionTime
     *
     *
     * Guidelines:
     * - For simplicity, use in-memory data structures to solve this problem, no need to use external system
     *
     * - Use programming language and editor of your choice
     *
     * - You can browse the web if you need any help
     */

    private static final Map<Long, HashSet<Transaction>> TRANSACTION_CACHE = new HashMap<>();
    private static final Long MILLIS_IN_AN_HOUR = 60L * 60L * 1000L;

    @Getter
    @Setter
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = {"transactionId"}, callSuper = false)
    public static class Transaction {
        private String transactionId;
        private Timestamp transactionTime;
        private Timestamp ttl;
    }
    @Getter
    @Setter
    public static class TransactionAttribute {
        private String key;
        private String value;
    }

    public Long getKey(final Transaction transaction) {
        long time = transaction.getTransactionTime() == null ? System.currentTimeMillis() : transaction.getTransactionTime().getTime();
        return null;
    }

    public Integer getMinute(long time) {
        return Math.toIntExact((System.currentTimeMillis() - time) / (60 * 1000));
    }

    public String input(final Transaction transaction) {
        Long ttl = (transaction.getTransactionTime() != null ? transaction.getTransactionTime().getTime() : System.currentTimeMillis()) + MILLIS_IN_AN_HOUR;
        HashSet<Transaction> bucketSet = TRANSACTION_CACHE.computeIfAbsent(ttl, k -> new HashSet<>());
        if(bucketSet.contains(transaction)) {
            return "DUPLICATE";
        }
        transaction.setTtl(new Timestamp(ttl));
        bucketSet.add(transaction);
        return "UNIQUE";
    }

    public void purge() {
        List<Long> toBeDeleted = TRANSACTION_CACHE.keySet().stream().filter(i -> (System.currentTimeMillis() - i) / (1000 * 60) >= 60).collect(Collectors.toList());
        if(!toBeDeleted.isEmpty()) {
            toBeDeleted.forEach(TRANSACTION_CACHE::remove);
        }
    }


    public static void main(String[] args) {
        Transaction txn = Transaction.builder()
                .transactionId("1")
                .transactionTime(new Timestamp(1583832656000L))
                .build();
        Transaction txn2 = Transaction.builder()
                .transactionId("2")
                .transactionTime(new Timestamp(System.currentTimeMillis()))
                .build();
        Transaction txn3 = Transaction.builder()
                .transactionId("1")
                .transactionTime(new Timestamp(1583832656000L))
                .build();
        Problem2 problem = new Problem2();
        System.out.println("input txn 1 -> " + problem.input(txn));
        System.out.println("input txn 2 -> " + problem.input(txn2));
        System.out.println("input txn 3 -> " + problem.input(txn3));
        System.out.println("O/P after input -> " + TRANSACTION_CACHE);
        problem.purge();
        System.out.println("O/P after purge -> " + TRANSACTION_CACHE);
    }

}
