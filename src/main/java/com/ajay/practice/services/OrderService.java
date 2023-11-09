package com.ajay.practice.services;

import com.ajay.practice.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

  Order claimOrder(Order order);
}
