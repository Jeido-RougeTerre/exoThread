package com.jeido.thread.exercises.exercise13;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    private final Lock lock = new ReentrantLock();

    public void use(String taskName) {
        try {
            System.out.println(taskName + " tente d'utiliser l'imprimante...");
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(taskName + " a acquis le verrou et utilise l'imprimante.");
                    Thread.sleep(1000);
                    System.out.println(taskName + " a terminé d'utiliser l'imprimante et libère le verrou.");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(taskName + " n'a pas pu accéder à l'imprimante (temps d'attente dépassé).");
            }
        } catch (InterruptedException e) {
            System.out.println(taskName + " a été interompu.");
        }
    }
}
