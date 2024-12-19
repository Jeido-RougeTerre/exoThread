package com.jeido.thread.exercises.exercise21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise21 {
    public static void main(String[] args) {
            try (ExecutorService server = Executors.newVirtualThreadPerTaskExecutor()) {

                for (int i = 0; i < 1000; i++) {
                    int finalI = i;
                    server.execute(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println("In-" + finalI + " is accepted by server.");
                    } catch (InterruptedException e) {
                        System.out.println("In-" + finalI + " is interrupted.");
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}
