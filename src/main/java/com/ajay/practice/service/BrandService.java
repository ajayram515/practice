package com.ajay.practice.service;

import com.ajay.practice.model.Brand;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BrandService {

    private Map<String , Brand> brandRepository = new HashMap<>();

    public Brand addBrand(Brand brand){
        if(brandRepository.containsKey(brand.getId())){
            throw new RuntimeException("brand already exist");
        }
        brandRepository.put(brand.getId(),brand);
        return brand;
    }

    public Brand removeBrand(String brandId) {
        if(!brandRepository.containsKey(brandId)){
            throw new RuntimeException("invalid brandId");
        }
        Brand brand = brandRepository.get(brandId);
        brandRepository.remove(brandId);
        return brand;
    }
}
