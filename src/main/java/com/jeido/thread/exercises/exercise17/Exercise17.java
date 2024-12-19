package com.jeido.thread.exercises.exercise17;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise17 {

    public static void main(String[] args) throws InterruptedException {
        //B31 C21 A52
        Shop shop = Shop.getInstance();
        shop.addItem("ProductA", 52);
        shop.addItem("ProductB", 31);
        shop.addItem("ProductC", 21);


        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new CommandExecutor(Command.makeCommandsForItems("Buyer-1", List.of(
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

        executor.submit(new CommandExecutor(Command.makeCommandsForItems("Buyer-2", List.of(
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

        executor.submit(new SupplyExecutor(Supply.getSupplyListForItems("Supplier", List.of(
                "ProductA",
                "ProductA",
                "ProductB",
                "ProductA",
                "ProductB"
        ))));

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.printf("Final Inventory: %s\n", shop.getInventory());
    }
}
