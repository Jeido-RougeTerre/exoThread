package com.jeido.thread.exercises.exercise20;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise20 {
    public static void main(String[] args) throws InterruptedException {
        long startTimeNative = System.currentTimeMillis();
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        int threadCount = 10_000;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
        long endTimeNative = System.currentTimeMillis();
        long endMemoryNative = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long startTimeVirtual = System.currentTimeMillis();
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        try {
            for (int i = 0; i < threadCount; i++) {
                executor.execute(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } finally {
            executor.shutdown();
        }

        long endTimeVirtual = System.currentTimeMillis();
        long endMemoryVirtual = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Native Thread : " + (endTimeNative - startTimeNative) + "ms Memory Used : " + (endMemoryNative - startMemory) + "\nVirtual Thread : " + (endTimeVirtual - startTimeVirtual) + "ms Memory Used : " + (endMemoryVirtual - startMemory));

    }
}
