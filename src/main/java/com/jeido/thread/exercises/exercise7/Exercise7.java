package com.jeido.thread.exercises.exercise7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise7 {
    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
                    int currentCounter = counter.getAndIncrement();
                    System.out.println("Message périodique " + currentCounter);
                    if (currentCounter >= 5) {
                        System.out.println("Programme terminé.");
                        executor.shutdown();
                    }
                },
                1,
                2,
                TimeUnit.SECONDS
        );

    }
}
