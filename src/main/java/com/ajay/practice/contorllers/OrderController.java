package com.ajay.practice.contorllers;

import com.ajay.practice.model.Deal;
import com.ajay.practice.model.Order;
import com.ajay.practice.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/claim")
    public Order claimOrder(@RequestBody Order order){
        return orderService.claimOrder(order);
    }
}
