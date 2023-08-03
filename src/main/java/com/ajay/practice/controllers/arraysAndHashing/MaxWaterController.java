package com.ajay.practice.controllers.arraysAndHashing;

import com.ajay.practice.service.MaxWaterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/max-water")
public class MaxWaterController {

    private final MaxWaterService maxWaterService;

    @PostMapping
    public int maxArea(@RequestBody int[] height){
        return maxWaterService.maxArea(height);
    }
}
