package com.ajay.practice.controller.arraysAndHashing;

import com.ajay.practice.service.SumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sum")
public class SumController {

    private final SumService sumService;

    @PostMapping()
    public List<Integer> twoSum(@RequestBody List<Integer> integerList, @RequestParam(value = "target") Integer target){
        return sumService.twoSum(integerList,target);
    }

    @PostMapping("/sorted-two-sum")
    public int[] sortedTwoSum(@RequestBody int[] integerList, @RequestParam(value = "target") Integer target){
        return sumService.sortedTwoSum(integerList,target);

    }

    @PostMapping("/three-sum")
    public List<List<Integer>> threeSum(@RequestBody int[] integerList){
        return sumService.threeSum(integerList);

    }
}
