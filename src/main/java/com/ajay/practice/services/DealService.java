package com.ajay.practice.services;

import com.ajay.practice.model.Deal;
import org.springframework.stereotype.Service;

@Service
public interface DealService {

  Deal createDeal(Deal deal);

  Boolean endDeal(String dealId, String userId);

  Deal updateDeal(Deal deal);

    Deal getDeal(String dealId);
}
