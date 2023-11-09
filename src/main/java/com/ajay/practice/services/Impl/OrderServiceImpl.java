package com.ajay.practice.services.Impl;

import com.ajay.practice.model.Deal;
import com.ajay.practice.model.Order;
import com.ajay.practice.model.User;
import com.ajay.practice.services.DealService;
import com.ajay.practice.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
  private Map<String, Order> orderRepository = new HashMap<>();
  private Map<String, Order> userProductRepository = new HashMap<>();
  private final DealService dealService;

  @Override
  public Order claimOrder(Order order) {
    Deal deal = dealService.getDeal(order.getDealId());
    if (deal.getAvailableItems() == 0) {
      throw new RuntimeException("deal expired");
    } else if (userProductRepository.containsKey(order.getUserId() + order.getProductId())) {
      throw new RuntimeException("already claimed deal");
    }
    deal.setAvailableItems(deal.getAvailableItems()-1);
    dealService.updateDeal(deal);
    orderRepository.put(order.getId(),order);
    userProductRepository.put(order.getUserId()+order.getProductId(),order);
    return order;
  }
}
