package com.example.store.Entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @BeforeEach
    public void beforeEach() {
        itemRepository.addItem(new Item("item1", 10000, 10));
        itemRepository.addItem(new Item("item2", 10000, 10));
    }

    @AfterEach
    public void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    public void 삽입() {
        String itemName = "item3";
        int price = 30000;
        int quantity = 30;
        Item item = new Item("item3", 30000, 30);
        Item savedItem = itemRepository.addItem(item);

        assertThat(item.getId()).isEqualTo(savedItem.getId());
        assertThat(savedItem.getItemName()).isEqualTo(itemName);
        assertThat(savedItem.getQuantity()).isEqualTo(quantity);
        assertThat(savedItem.getPrice()).isEqualTo(price);
    }

    @Test
    public void 수정() {
        Item item3 = new Item("item3", 30000, 30);
        itemRepository.addItem(item3);
        Item paramItem = new Item("item4", 40000, 40);

        itemRepository.editItem(item3.getId(), paramItem);

        assertThat(item3.getItemName()).isEqualTo("item4");
        assertThat(item3.getPrice()).isEqualTo(40000);
        assertThat(item3.getQuantity()).isEqualTo(40);


    }


    @Test
    public void 조회() {
        Item item3 = itemRepository.addItem(new Item("item3", 30000, 30));
        Item findItem = itemRepository.findById(item3.getId());

        assertThat(findItem.getPrice()).isEqualTo(30000);
    }

    @Test
    public void 모두조회() {
        Item item3 = itemRepository.addItem(new Item("item3", 30000, 30));
        List<Item> items = itemRepository.findAll();

        assertThat(items.size()).isEqualTo(3);
        assertThat(items).contains(item3);
    }

    @Test
    public void 삭제(){
        Item item3 = new Item("item3", 30000, 30);
        itemRepository.addItem(item3);
        itemRepository.deleteItem(item3.getId());

        List<Item> items = itemRepository.findAll();

        assertThat(items).doesNotContain(item3);
    }




}