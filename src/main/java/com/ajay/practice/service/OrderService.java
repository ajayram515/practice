package com.ajay.practice.service;

import com.ajay.practice.model.Brand;
import com.ajay.practice.model.Order;
import com.ajay.practice.model.Status;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private Map<String , Order> orderRepository = new HashMap<>();


    public Order placeOrder(Order order) {
        if(orderRepository.containsKey(order.getId())){
            throw new RuntimeException("order already place");
        }
        return orderRepository.put(order.getId(),order);
    }

    public Order getOrderById(String orderId) {
        if(!orderRepository.containsKey(orderId)){
            throw new RuntimeException("order doesnt exist");
        }
        return orderRepository.get(orderId);
    }

    public void updateStatus(String orderId, Status newStatus) {
        if(!orderRepository.containsKey(orderId)){
            throw new RuntimeException("order doesnt exist");
        }
        Order order =orderRepository.get(orderId);
        order.setStatus(newStatus);
        orderRepository.put(orderId,order);
    }
}
