package com.jeido.thread.exercises.exercise16;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Exercise16 {
    private static final int NB_THREADS = 4;
    public static void main(String[] args) throws InterruptedException {
        int[] result = new int[NB_THREADS];
        int[] arr = new int[NB_THREADS * 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }


        CyclicBarrier barrier = new CyclicBarrier(NB_THREADS,
                () -> System.out.println("Sum : " + Arrays.stream(result).sum())
        );

        Thread[] threads = new Thread[NB_THREADS];

        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            int indexA = i * 2;
            int indexB = indexA + 1;
            threads[i] = new Thread(() -> {
                int sum = arr[indexA] + arr[indexB];
                result[finalI] = sum;
                System.out.printf("%s calculated partial sum of (index : %d to index %d) : %d%n",
                        Thread.currentThread().getName(),
                        indexA,
                        indexB,
                        sum
                );
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        for (Thread thread : threads) thread.start();

        for (Thread thread : threads) thread.join();

    }
}
