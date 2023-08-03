package com.ajay.practice.controllers.arraysAndHashing;

import com.ajay.practice.service.AnagramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/anagram")
public class AnagramController {

    private final AnagramService anagramService;

    @GetMapping()
    public Boolean checkAnagram(@RequestParam(value = "s1") String s1,@RequestParam(value = "s2") String s2){
        return anagramService.checkAnagram(s1,s2);
    }
}
