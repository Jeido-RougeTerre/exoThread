package com.jeido.thread.exercises.exercise14;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Exercise14 {
    private static final int NB_THREADS = 3;
    public static void main(String[] args) throws InterruptedException {
        int nbThreads;
        if (args.length >= 1) {
            try {
                nbThreads = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                nbThreads = NB_THREADS;
            }
        } else {
            nbThreads = NB_THREADS;
        }

        CyclicBarrier barrier = new CyclicBarrier(nbThreads);

        Runnable loadTask = () -> {
            System.out.println(Thread.currentThread().getName() + " is loading data...");
            try {
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " finished loading data.");
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread[] threads = new Thread[nbThreads];
        for (int i = 0; i < nbThreads; i++) {
            threads[i] = new Thread(loadTask);
            threads[i].start();
        }

        for (Thread thread : threads) thread.join();
        System.out.println("Data assembling done.");

    }
}
