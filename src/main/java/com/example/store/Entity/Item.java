package com.example.store.Entity;

// DB에 mapping이 될 Class(Entity Class)

import lombok.*;

@Data
public class Item {

    private Long id;
    private String itemName;
    private int price;
    private int quantity;
    public Item(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
