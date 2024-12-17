package com.jeido.thread.exercises.exercise11;

import com.jeido.thread.ui.Ansi;

import java.util.concurrent.locks.ReentrantLock;

public class Exercise11 {
    private static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        BankAccount ba = new BankAccount();

        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    ba.deposit(10);
                }
            } finally {
                lock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    ba.withdraw(10);
                }
            } finally {
                lock.unlock();
            }
        });

        Thread thread3 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    ba.deposit(10);
                }
            } finally {
                lock.unlock();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.printf("Solde final : %s%.2f$%s%n", Ansi.GREEN.getCode(), ba.getBalance(), Ansi.RESET.getCode());

    }


}
