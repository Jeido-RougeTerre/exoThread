package com.jeido.thread.exercises.exercise17;

import java.util.ArrayList;
import java.util.List;

public class Supply {
    private Shop shop = Shop.getInstance();
    private String supplierName;
    private String itemName;
    private int quantity;

    public Supply(String supplierName, String itemName, int quantity) {
        this.supplierName = supplierName;
        this.itemName = itemName;
        this.quantity = Math.max(quantity, 1);
    }

    public Supply(String supplierName, String itemName) {
        this.supplierName = supplierName;
        this.itemName = itemName;
        this.quantity = 10;
    }

    public void supply() {
        shop.supplyItem(itemName, quantity);
        System.out.printf("%s supplied %d units of %s\n", supplierName, quantity, itemName);
    }

    public static List<Supply> getSupplyListForItems(String supplierName, List<String> itemNames, int quantity) {
        List<Supply> supplyList = new ArrayList<Supply>();
        for (String itemName : itemNames) {
            supplyList.add(new Supply(supplierName, itemName, quantity));
        }
        return supplyList;
    }

    public static List<Supply> getSupplyListForItems(String supplierName, List<String> itemNames) {
        return getSupplyListForItems(supplierName, itemNames, 10);
    }
}
