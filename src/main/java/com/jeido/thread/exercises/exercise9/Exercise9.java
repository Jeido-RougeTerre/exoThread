package com.jeido.thread.exercises.exercise9;

import java.util.concurrent.atomic.AtomicInteger;

public class Exercise9 {
    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = createAtomicThreads();
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();

        System.out.println("Valeur finale du compteur : " + counter.get());

    }

    private static Thread[] createAtomicThreads() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> System.out.println(Thread.currentThread().getName() + " a incrémenté le compteur à " + counter.incrementAndGet()));
        }
        return threads;
    }
}
