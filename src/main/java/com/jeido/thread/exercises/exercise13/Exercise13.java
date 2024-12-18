package com.jeido.thread.exercises.exercise13;


public class Exercise13 {

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            String name = "Tâche-" + (i + 1);
            threads[i] = new Thread(() -> printer.use(name));
        }

        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();

        System.out.println("Toutes les tâches sont terminées.");

    }
}
