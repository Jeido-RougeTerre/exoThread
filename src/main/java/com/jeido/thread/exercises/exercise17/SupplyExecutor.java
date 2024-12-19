package com.jeido.thread.exercises.exercise17;

import java.util.List;

public class SupplyExecutor implements Runnable {
    private List<Supply> supplyList;

    public SupplyExecutor(List<Supply> supplyList) {
        this.supplyList = supplyList;
    }

    @Override
    public void run() {
        for (Supply supply : supplyList) {
            supply.supply();
        }
    }
}
