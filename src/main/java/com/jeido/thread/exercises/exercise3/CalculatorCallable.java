package com.jeido.thread.exercises.exercise3;

import java.util.concurrent.Callable;

public class CalculatorCallable implements Callable<Integer> {
    private final int n;

    public CalculatorCallable(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        return n * n * n;
    }
}
