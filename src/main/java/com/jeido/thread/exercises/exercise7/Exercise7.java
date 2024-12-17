package com.jeido.thread.exercises.exercise7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise7 {
    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> System.out.println("Message périodique " + counter.incrementAndGet()),
                1,
                2,
                TimeUnit.SECONDS
        );
        while (counter.get() < 5) {}
        executor.shutdown();
        System.out.println("Programme terminé.");

    }
}
