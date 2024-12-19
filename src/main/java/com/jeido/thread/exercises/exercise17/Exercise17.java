package com.jeido.thread.exercises.exercise17;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Exercise17 {
    private final ConcurrentHashMap<String, Integer> inventory = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException {
        //B31 C21 A52
        Shop shop = Shop.getInstance();
        shop.addItem("ProductA", 52);
        shop.addItem("ProductB", 31);
        shop.addItem("ProductC", 21);
        Thread buyer1 = new Thread(new CommandExecutor(Command.makeCommandsForItems("Buyer-1", List.of(
                "ProductC",
                "ProductA",
                "ProductB",
                "ProductC",
                "ProductA",
                "ProductA",
                "ProductB",
                "ProductA",
                "ProductC",
                "ProductA"
        ))));

        Thread buyer2 = new Thread(new CommandExecutor(Command.makeCommandsForItems("Buyer-2", List.of(
                "ProductA",
                "ProductA",
                "ProductB",
                "ProductB",
                "ProductC",
                "ProductB",
                "ProductA",
                "ProductC",
                "ProductB",
                "ProductC"
        ))));

        Thread supplier = new Thread(new SupplyExecutor(Supply.getSupplyListForItems("Supplier", List.of(
                "ProductA",
                "ProductA",
                "ProductB",
                "ProductA",
                "ProductB"
        ))));

        buyer1.start();
        buyer2.start();
        supplier.start();

        buyer1.join();
        buyer2.join();
        supplier.join();

        System.out.printf("Final Inventory: %s\n", shop.getInventory());
    }
}
