package com.ajay.practice.contorllers;

import com.ajay.practice.model.Deal;
import com.ajay.practice.services.DealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deal")
@AllArgsConstructor
public class DealController {

    private final DealService dealService;

    @PostMapping("/create")
    public Deal createDeal(@RequestBody Deal deal){
        return dealService.createDeal(deal);
    }

    @GetMapping("/end")
    public Boolean endDeal(@RequestParam String dealId,@RequestParam String userId){
        return dealService.endDeal(dealId,userId);
    }

    @PostMapping("/update")
    public Deal updateDeal(@RequestBody Deal deal){
        return dealService.updateDeal(deal);
    }
}
