package com.jeido.thread.exercises.exercise3;

import java.util.concurrent.*;

public class Exercise3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer>[] futures = new Future[5];
        for (int i = 1; i <= 5; i++) {
            futures[i - 1] = executor.submit(new CalculatorCallable(i));
        }
        for (int i = 0; i < futures.length; i++) {
            try {
                System.out.println("Le cube de " + (i + 1) + " est " + futures[i].get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Erreur de execution pour " + i);
            }
        }
        executor.shutdown();

    }
}
