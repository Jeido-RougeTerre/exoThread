package com.jeido.thread.exercises.exercise18;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise18 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        Runnable addTask = () -> {
            for (int i = 0; i < 10; i++) {
                list.add(Thread.currentThread().getName() + "-" + "Product-" + i);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(addTask);
        executor.submit(addTask);

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(150);
        }
        System.out.println("List : " + list);
    }
}
