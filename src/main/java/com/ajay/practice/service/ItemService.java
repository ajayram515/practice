package com.ajay.practice.service;

import com.ajay.practice.model.swigito.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {
    private Map<String , Item> itemRepository = new HashMap<>();

    public Item addItem(Item item) {
        if(itemRepository.containsKey(item.getId())){
            throw new RuntimeException("item already exist");
        }
        return itemRepository.put(item.getId(),item);
    }

    public void updateItem(Item item) {
        if(!itemRepository.containsKey(item.getId())){
            throw new RuntimeException("item doesn't  exist");
        }
        itemRepository.put(item.getId(),item);
    }

    public void removeItem(Item item) {
        if(!itemRepository.containsKey(item.getId())){
            throw new RuntimeException("item doesn't  exist");
        }
        itemRepository.remove(item.getId());
    }
}
