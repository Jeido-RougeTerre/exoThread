package com.jeido.thread.exercises.exercise5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exercise5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Integer>[] futures = new Future[10];
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i < 11; i++) {
            futures[i - 1] = executor.submit(new Square(i));
        }

        for (int i = 0; i < futures.length; i++) {
            System.out.println("Task " + (i + 1) + ": " + futures[i].get());
        }
        executor.shutdown();
    }
}
