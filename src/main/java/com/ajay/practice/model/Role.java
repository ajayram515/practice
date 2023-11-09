package com.ajay.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    BUYER("buyer"),
    SELLER("seller"),
    ADMIN("admin");

    private final String name;
}
