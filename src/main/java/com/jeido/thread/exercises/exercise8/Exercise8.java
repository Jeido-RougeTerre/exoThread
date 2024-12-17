package com.jeido.thread.exercises.exercise8;

import java.util.concurrent.atomic.AtomicInteger;

public class Exercise8 {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = createAtomicThreads();
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
        System.out.println("Value of counter: " + counter.get());
    }

    private static Thread[] createAtomicThreads() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i]  = new Thread(() -> {
                for (int j = 0; j < 1_000; j++) {
                    counter.incrementAndGet();
                }
            });
        }
        return threads;
    }
}
