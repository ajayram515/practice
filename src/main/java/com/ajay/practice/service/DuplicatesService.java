package com.ajay.practice.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DuplicatesService {

    public Boolean checkDuplicates(List<Integer> list) {
        Set<Integer> deDuplicatedList= new HashSet<>();
        for(Integer number : list){
            if(deDuplicatedList.contains(number)){
                return true;
            }
            deDuplicatedList.add(number);
        }
        return false;
    }
}
