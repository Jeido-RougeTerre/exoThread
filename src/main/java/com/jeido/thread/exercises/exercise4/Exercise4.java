package com.jeido.thread.exercises.exercise4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise4 {
    public static void main(String[] args) {
    exercise4();
    }

    private static void exercise4() {
        ExecutorService executor = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            executor.execute(() -> System.out.printf("%nTask %02d executed by %s", taskId, Thread.currentThread().getName()));
        }
        executor.shutdown();
    }
}
