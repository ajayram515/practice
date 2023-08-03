package com.ajay.practice.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
    public Boolean isPalindrome(String s) {
        long time = System.currentTimeMillis();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        // Convert all characters to lowercase
        s = s.toLowerCase();
        StringBuilder s2 = new StringBuilder(s);

        s2.reverse();

        return s.equals(s2.toString());

    }
}
