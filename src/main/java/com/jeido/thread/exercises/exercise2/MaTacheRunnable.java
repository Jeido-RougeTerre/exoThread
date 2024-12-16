package com.jeido.thread.exercises.exercise2;

public class MaTacheRunnable implements Runnable {
    private int n;

    public MaTacheRunnable(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Le carré de " + n + " est " + n * n);
    }
}
