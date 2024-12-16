package com.jeido.thread.exercises.exercise5;

import java.util.concurrent.Callable;

public class Square implements Callable<Integer> {
    private int x;
    public Square(int x) {
        this.x = x;
    }

    public Integer call() throws Exception {
        return x * x;
    }
}
