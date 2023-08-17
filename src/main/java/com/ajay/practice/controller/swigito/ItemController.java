package com.ajay.practice.controller.swigito;

import com.ajay.practice.model.swigito.Item;
import com.ajay.practice.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/add")
    public Item addItem(@RequestBody Item item){
       return itemService.addItem(item);
    }

    @PostMapping("/item/update")
    public void updateItem(@RequestBody Item item){
        itemService.updateItem(item);
    }


    @PostMapping("/item/remove")
    public void removeItem(@RequestBody Item item){
        itemService.removeItem(item);
    }

}
