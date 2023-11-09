package com.ajay.practice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deal {
    private String id;
    private String sellerId;
    private String productId;
    private long price;
    private long startTime;
    private long endTime;
    private String status;
    private int availableItems;
}
