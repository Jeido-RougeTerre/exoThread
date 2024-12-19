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
        if (!inventory.containsKey(item)) return;
        int q = inventory.get(item);
        if (quantity < q) return;
        inventory.put(item, quantity - q);
    }

    public void supplyItem(String item, int quantity) {
        if (!inventory.containsKey(item)) return;
        int q = inventory.get(item);
        inventory.put(item, q + quantity);
    }

    public ConcurrentHashMap<String, Integer> getInventory() {
        return inventory;
    }
}
