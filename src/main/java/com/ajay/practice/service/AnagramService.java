package com.ajay.practice.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnagramService {


    public Boolean checkAnagram(String s1, String s2) {
        Map<Character, Long> dictionary1 = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map<Character, Long> dictionary2 = s2.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return dictionary1.equals(dictionary2);
    }
}
