package com.example.store.Entity;

// DB에 mapping이 될 Class(Entity Class)

public class Item {

    public Item(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    private int itemNum;
    private String itemName;
    private int price;
    private int quantity;
}
