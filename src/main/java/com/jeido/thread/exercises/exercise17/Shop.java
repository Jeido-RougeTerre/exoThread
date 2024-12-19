package com.jeido.thread.exercises.exercise17;

import java.util.concurrent.ConcurrentHashMap;

public class Shop {
    private static Shop instance;
    private final ConcurrentHashMap<String, Integer> inventory;
    private Shop() {
        inventory = new ConcurrentHashMap<>();
    }
    public static Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public void addItem(String item, int quantity) {
        inventory.put(item, quantity);
    }

    public void buyItem(String item, int quantity) {
        inventory.computeIfPresent(item, (k, v) -> v >= quantity ? v - quantity : 0);
    }

    public void supplyItem(String item, int quantity) {
        inventory.merge(item, quantity, Integer::sum);
    }

    public ConcurrentHashMap<String, Integer> getInventory() {
        return inventory;
    }
}
