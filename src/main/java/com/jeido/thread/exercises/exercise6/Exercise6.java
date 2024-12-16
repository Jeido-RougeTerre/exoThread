package com.jeido.thread.exercises.exercise6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Exercise6 {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            int finalI = i;
            executor.schedule(() -> System.out.println("Task " + finalI + " executed after " + finalI + "second" + (finalI == 1 ? "." : "s.") ), i, TimeUnit.SECONDS);
        }

        // Periodic Task
        executor.schedule(() -> System.out.println("All task executed"), 4, TimeUnit.SECONDS);

        executor.shutdown();
    }
}
