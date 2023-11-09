package com.ajay.practice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String id;
    private String productId;
    private String userId;
    private String dealId;
}
