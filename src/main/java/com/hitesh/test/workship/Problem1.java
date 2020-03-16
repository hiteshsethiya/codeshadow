package com.hitesh.test.workship;

import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem1 {

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

    private static final HashSet<Transaction> TRANSACTION_CACHE = new HashSet<>();
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


    public String input(final Transaction transaction) {
        if(TRANSACTION_CACHE.contains(transaction)) {
            return "DUPLICATE";
        }
        long ttl = (transaction.getTransactionTime() != null ? transaction.getTransactionTime().getTime() : System.currentTimeMillis()) + MILLIS_IN_AN_HOUR;
        transaction.setTtl(new Timestamp(ttl));
        TRANSACTION_CACHE.add(transaction);
        return "UNIQUE";
    }

    public void purge() {
        List<Transaction> toBeDeleted = TRANSACTION_CACHE.stream()
                .filter(iTxn -> iTxn.getTtl().getTime() <= System.currentTimeMillis()).collect(Collectors.toList());
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
        Problem1 problem = new Problem1();
        System.out.println(problem.input(txn));
        System.out.println(problem.input(txn2));
        System.out.println(problem.input(txn3));
        System.out.println(TRANSACTION_CACHE);
        problem.purge();
        System.out.println(TRANSACTION_CACHE);
    }

}
