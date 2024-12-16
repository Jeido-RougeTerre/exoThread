package com.jeido.thread.exercises.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            Thread thread = new Thread(new MaTacheRunnable(i));
            thread.start();
        }
    }
}
