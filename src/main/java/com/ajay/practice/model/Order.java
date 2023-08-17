package com.ajay.practice.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String id;
    private String brandId;
    private List<Item> itemList;
    private Status status;
    private long time;
}
