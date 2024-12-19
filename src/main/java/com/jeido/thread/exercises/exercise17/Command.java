package com.jeido.thread.exercises.exercise17;

import java.util.*;

public class Command {
    private Shop shop = Shop.getInstance();
    private String itemName;
    private String buyerName;
    private int quantity;

    public Command(String itemName, String buyerName, int quantity) {
        this.itemName = itemName;
        this.buyerName = buyerName;
        this.quantity = Math.max(quantity, 1);
    }

    public Command(String itemName, String buyerName) {
        this.itemName = itemName;
        this.buyerName = buyerName;
        this.quantity = 1;
    }

    public void buy() {
        shop.buyItem(itemName, quantity);
        System.out.printf("%s bought %d units of %s\n", buyerName, quantity, itemName);
    }

    public static List<Command> makeCommandsForItems(String buyerName, List<String> itemNames, int quantity) {
        List<Command> commands = new ArrayList<Command>();
        for (String itemName : itemNames) {
            commands.add(new Command(itemName, buyerName, quantity));
        }
        return commands;
    }

    public static List<Command> makeCommandsForItems(String buyerName, List<String> itemNames) {
        return makeCommandsForItems(buyerName, itemNames, 1);
    }
}
