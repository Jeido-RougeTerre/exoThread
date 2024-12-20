package com.jeido.thread.exercises.exercise22;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise22 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        CompletableFuture<Void> readTask = CompletableFuture.runAsync(() -> {
            System.out.println("Reading data...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, executor);

        CompletableFuture<Void> workTask = readTask.thenRunAsync(() -> {
            System.out.println("Analizing data...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, executor);

        CompletableFuture<Void> writeTask = workTask.thenRunAsync(() -> {
            System.out.println("Writing data...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, executor);

        writeTask.join();
        System.out.println("Done.");
    }
}
