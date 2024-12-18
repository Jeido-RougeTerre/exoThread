package com.jeido.thread.exercises.exercise15;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Exercise15 {
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

        Runnable stepsTask = () -> {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " reached step " + (i + 1));
                    barrier.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread[] threads = new Thread[nbThreads];
        for (int i = 0; i < nbThreads; i++) {
            threads[i] = new Thread(stepsTask);
            threads[i].start();
        }

        for (Thread thread : threads) thread.join();
    }
}
