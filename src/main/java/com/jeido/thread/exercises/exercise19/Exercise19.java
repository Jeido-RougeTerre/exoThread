package com.jeido.thread.exercises.exercise19;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise19 {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        Runnable addTask = () -> {
            for (int i = 0; i < 10; i++) {
                String item = "Producer-Element-" + i;
                queue.add(item);
                System.out.println("Producer added: " + item);
            }
        };

        Runnable removeTask = () -> {
            for (int i = 0; i < 10; i++) {
                String item = queue.poll();
                if (item != null) {
                    System.out.println("Consumer removed: " + item);
                } else {
                    System.out.println("Consumer could not remove item");
                }

            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(addTask);
        executorService.submit(removeTask);
        executorService.shutdown();

        while (!executorService.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("Queue : " + queue);
    }
}
