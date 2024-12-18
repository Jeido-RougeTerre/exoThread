package com.jeido.thread.exercises.exercise11;

import com.jeido.thread.ui.Ansi;

public class Exercise11 {
    public static void main(String[] args) throws InterruptedException {
        BankAccount ba = new BankAccount();

        Runnable depositTask = () -> {
            for (int i = 0; i < 5; i++) {
                ba.deposit(10);
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 5; i++) {
                ba.withdraw(10);
            }
        };

        Thread thread1 = new Thread(depositTask);
        Thread thread2 = new Thread(withdrawTask);
        Thread thread3 = new Thread(depositTask);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.printf("Solde final : %s%.2f$%s%n", Ansi.GREEN.getCode(), ba.getBalance(), Ansi.RESET.getCode());

    }


}
