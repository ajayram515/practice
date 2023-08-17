package com.ajay.practice.controller;

import com.ajay.practice.model.Brand;
import com.ajay.practice.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    @PostMapping("/brand/add")
    public Brand addbrand(@RequestBody Brand brand){

        return brandService.addBrand(brand);
    }

    @GetMapping("/remove")
    public Brand removeBrand(@RequestParam(value = "id") String brandId){
        return brandService.removeBrand(brandId);
    }

}
