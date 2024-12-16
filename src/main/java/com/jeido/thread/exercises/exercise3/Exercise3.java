package com.jeido.thread.exercises.exercise3;

import java.util.concurrent.*;

public class Exercise3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 6; i++) {
            CalculatorCallable calculatorCallable = new CalculatorCallable(i);

            Future<Integer> result = executor.submit(calculatorCallable);
            System.out.println("Le cube de " + i + " est " + result.get());
        }
        executor.shutdown();

    }
}
