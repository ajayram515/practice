package com.ajay.practice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private String emailId;
    private Role role;
}
