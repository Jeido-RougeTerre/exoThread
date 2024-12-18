package com.jeido.thread.exercises.exercise12;

public class Exercise12 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                SharedResource.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                SharedResource.remove(i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        SharedResource.getList();
    }
}
