package com.ajay.practice.controllers.arraysAndHashing;

import com.ajay.practice.service.PalindromeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/palindrome")
public class PalindromeController {
    private final PalindromeService palindromeService;

    @PostMapping
    public Boolean isPalindrome(@RequestBody String s){
        return palindromeService.isPalindrome(s);
    }
}
