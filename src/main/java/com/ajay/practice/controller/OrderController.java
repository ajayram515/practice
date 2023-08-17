package com.ajay.practice.controller;

import com.ajay.practice.model.Order;
import com.ajay.practice.model.Status;
import com.ajay.practice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/order/add")
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }

    @GetMapping("/order/{order_id}")
    public Order getOrderById(@PathVariable(value = "order_id") String orderId){
        return orderService.getOrderById(orderId);

    }

    @GetMapping("/order")
    public void udateOrderStatus(@RequestParam(value = "order_id") String orderId,@RequestParam(value = "status") Status newStatus){
        orderService.updateStatus(orderId,newStatus);

    }
}
