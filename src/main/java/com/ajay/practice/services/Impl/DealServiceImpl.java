package com.ajay.practice.services.Impl;

import com.ajay.practice.model.Deal;
import com.ajay.practice.model.Role;
import com.ajay.practice.model.User;
import com.ajay.practice.services.DealService;
import com.ajay.practice.services.ProductService;
import com.ajay.practice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class DealServiceImpl implements DealService {
    private Map<String,Deal> dealRepository = new HashMap<>();

    private final UserService userService;

    private final ProductService productService;

    @Override
    public Deal createDeal(Deal deal) {
        User user = userService.getUser(deal.getSellerId());
        if(user.getRole().equals(Role.SELLER)){
            if(!productService.checkProduct(deal.getProductId())){
                throw new RuntimeException("product doesnt exist");
            }

            if(dealRepository.containsKey(deal.getId())){
                throw new RuntimeException("deal already exists");
            }
            deal.setStatus("Active");
            dealRepository.put(deal.getId(), deal);
            return deal;
        }

        throw new RuntimeException("user don't have access to create deal");
    }

    @Override
    public Boolean endDeal(String dealId, String userId) {
        Deal deal = dealRepository.containsKey(dealId)?dealRepository.get(dealId):null;
        if(Objects.isNull(deal)){
            throw new RuntimeException("not a valid deal");
        }


        User user = userService.getUser(userId);
        if(!user.getId().equals(deal.getSellerId())){
            throw new RuntimeException("not a valid user");
        }
        deal.setStatus("Inactive");
        return true;
    }

    @Override
    public Deal updateDeal(Deal deal) {
        Deal existingDeal = dealRepository.containsKey(deal.getId())?dealRepository.get(deal.getId()):null;
        if(Objects.isNull(existingDeal)){
            throw new RuntimeException("not a valid deal");
        }

        if(!existingDeal.getSellerId().equals(deal.getSellerId())){
            throw new RuntimeException("not a valid user");
        }
            existingDeal.setPrice(deal.getPrice());
            existingDeal.setEndTime(deal.getEndTime());
            existingDeal.setAvailableItems(deal.getAvailableItems());
            dealRepository.put(deal.getId(), deal);
            return deal;
    }

    @Override
    public Deal getDeal(String dealId) {
        if(dealRepository.containsKey(dealId)){

            Deal deal = dealRepository.get(dealId);
            if (deal.getStatus().equals("Active")){
                return deal;
            }
        }
        throw new RuntimeException("no deal exist");
    }
}
