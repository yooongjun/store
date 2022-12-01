package com.example.store.Entity;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 데이터에 접근
@Repository
public class ItemRepository {

    // 등록 순으로 Item에 id 부여
    private Long sequence = 0l;

    // DB 연동 전이므로 메모리에 데이터 저장하기
    private static Map<Long, Item> storeMap = new HashMap<>();

    // 삽입
    public Item addItem(Item item) {
        item.setId(sequence++);
        storeMap.put(item.getId(), item);
        return item;
    }

    // 수정
    public void editItem(Long id, Item paramItem) {
        Item item = findById(id);
        item.setItemName(paramItem.getItemName());
        item.setPrice(paramItem.getPrice());
        item.setQuantity(paramItem.getQuantity());
    }

    // 조회
    public Item findById(Long id) {
        return storeMap.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(storeMap.values());
    }

    // 삭제
    // 남아있는 item들의 id 수정 과정은 이후 DB 사용할 것이므로 생략
    public void deleteItem(Long id) {
        storeMap.remove(id);
    }

    // 디버깅용 전체 삭제
    public void clearStore() {
        storeMap.clear();
    }


}
