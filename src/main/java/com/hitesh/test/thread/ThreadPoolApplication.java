package com.hitesh.test.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolApplication {

    private final ExecutorService executorService;
    private final ServerSocket serverSocket;


    public static class Executable implements Runnable {

        private Runnable runnable;

        public Executable(Runnable runnable) {
            this.runnable = runnable;
        }

        public void setRunnable(Runnable runnable) {
            this.runnable = runnable;
        }

        public void run() {
            if (this.runnable != null) {
                this.runnable.run();
            }
        }
    }

    public ThreadPoolApplication() throws IOException {
        this.executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                System.out.println();
                Thread thread = new Thread(new Executable(runnable));
                thread.setName("Baba! " + System.currentTimeMillis() % 10000000);
                System.out.println("Created new thread " + thread.getName());
                return thread;
            }
        });
        this.serverSocket = new ServerSocket(8080);
    }

    public static class Sample implements Runnable {
        static Integer count = 0;

        public void run() {
            synchronized (Sample.class) {
                count++;
            }
            System.out.println("Running at " + count);
        }
    }

    public static class Sample1 implements Runnable {
        static Integer count = 0;

        public void run() {
            count++;
            System.out.println("Running at S1 " + count);
        }
    }

    public static void executorServiceSample() throws IOException {
        Sample s = new Sample();
        Sample1 s1 = new Sample1();
        ThreadPoolApplication threadApp = new ThreadPoolApplication();
        for (AtomicInteger i = new AtomicInteger(0); i.get() < 100; ) {
            if (i.get() % 2 == 0)
                threadApp.executorService.submit(
                        new Executable(s)
                );
            else
                threadApp.executorService.submit(
                        new Executable(s1)
                );
            i.incrementAndGet();
        }

        for (int i = 0; i < 100; ++i) {
            synchronized (ThreadPoolApplication.class) {
                if (i % 2 == 0)
                    threadApp.executorService.submit(
                            new Executable(s)
                    );
                else
                    threadApp.executorService.submit(
                            new Executable(s1)
                    );
            }
        }
    }

    static Thread t1;

    public static void main(String[] args) throws IOException {
        Executable e1 = new Executable(new Runnable() {
            public void run() {
                System.out.println("This is the first one!");
            }
        });
        t1 = new Thread(e1);
        t1.run();
        e1.setRunnable(new Runnable() {
            public void run() {
                System.out.println("This is the second one!");
            }
        });
        t1.run();
    }
}
