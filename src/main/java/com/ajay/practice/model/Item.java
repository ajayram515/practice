package com.ajay.practice.model;

import lombok.Data;

@Data
public class Item {
    private String id;
    private String menuId;
    private String name;
    private double price;
}
