package com.jeido.thread.exercises.exercise3;

import java.util.concurrent.Callable;

public class CalculatorCallable implements Callable<String> {
    private final int n;

    public CalculatorCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        return "Le cube de " + n + " est " + n * n * n;
    }
}
