package com.jeido.thread.exercises.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        MonPremierThread thread1 = new MonPremierThread();
        thread1.start();
        MonPremierThread thread2 = new MonPremierThread();
        thread2.start();
        MonPremierThread thread3 = new MonPremierThread();
        thread3.start();
    }
}
