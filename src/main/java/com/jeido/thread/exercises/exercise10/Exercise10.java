package com.jeido.thread.exercises.exercise10;

import java.util.concurrent.atomic.AtomicLong;

public class Exercise10 {
    public static void main(String[] args) throws InterruptedException {
        AtomicLong atoVal = new AtomicLong(1);
        Thread[] threads = new Thread[5];
        for (int i = 1; i <= threads.length; i++) {
            int mult = i + 1;
            long res = atoVal.updateAndGet(v -> mult * v);
            threads[i - 1] = new Thread(() -> System.out.println(Thread.currentThread().getName() + " multiplicateur : " + mult + " = " + res));
            threads[i].start();
        }
        for (Thread thread : threads) thread.join();

        System.out.println("Valeur finale : " + atoVal.get());
    }
}
