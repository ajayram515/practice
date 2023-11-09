package com.ajay.practice.services;

import com.ajay.practice.model.Order;
import com.ajay.practice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  User createUser(User user);

    User getUser(String sellerId);
}
