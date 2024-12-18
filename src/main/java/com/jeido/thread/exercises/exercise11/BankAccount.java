package com.jeido.thread.exercises.exercise11;

import com.jeido.thread.ui.Ansi;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this(0.0);
    }

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        this.balance += amount;
        System.out.printf("%s deposited %s%.2f$%s, current balance : %.2f$%n",
                Thread.currentThread().getName(),
                Ansi.GREEN.getCode(),
                amount,
                Ansi.RESET.getCode(),
                this.balance
        );
    }

    public synchronized void withdraw(double amount) {
        if (this.balance < amount) {
            System.out.printf(
                    "%s%s couldn't withdraw %s%.2f$%s (Insufficient funds). Current balance : %.2f$%s%n",
                    Ansi.RED.getCode(),
                    Thread.currentThread().getName(),
                    Ansi.RED_BOLD_BRIGHT.getCode(),
                    amount,
                    Ansi.RESET.getCode() + Ansi.RED.getCode(),
                    this.balance,
                    Ansi.RESET.getCode()
            );
        } else {
            this.balance -= amount;
            System.out.printf("%s withdraw %s%.2f$%s, current balance : %.2f$%n",
                    Thread.currentThread().getName(),
                    Ansi.RED.getCode(),
                    amount,
                    Ansi.RESET.getCode(),
                    this.balance
            );
        }
    }

}
