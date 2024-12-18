package com.jeido.thread.exercises.exercise13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise13 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        SharedResource sr = new SharedResource();

        Runnable addTask = () -> {
            try {
                lock.tryLock(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.out.println("couldn't acquire lock");
            } finally {
                lock.unlock();
            }
            for (int i = 0; i < 10; i++) {
                sr.add(i);
            }
        };

        Runnable removeTask = () -> {
            try {
                lock.tryLock(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.out.println("couldn't acquire lock");
            } finally {
                lock.unlock();
            }
            for (int i = 0; i < 10; i++) {
                sr.remove(i);
            }
        };

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            if (Math.random() < 0.5) {
                threads[i] = new Thread(addTask);
            } else {
                threads[i] = new Thread(removeTask);
            }
        }

        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();

        sr.getList();


    }
}
