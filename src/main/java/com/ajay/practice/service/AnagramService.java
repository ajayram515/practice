package com.ajay.practice.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AnagramService {


    public Boolean checkAnagram(String s1, String s2) {
        HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();
        for(int i = 0; i < s1.length(); i++){
            if(dictionary.containsKey(s1.charAt(i))){
                dictionary.put(s1.charAt(i),1+dictionary.get(s1.charAt(i)));
            }else {
                dictionary.put(s1.charAt(i),1);
            }
        }
        for(int i = 0; i < s2.length(); i++){
            if(dictionary.containsKey(s2.charAt(i))){
                dictionary.put(s2.charAt(i),dictionary.get(s2.charAt(i))-1);
            }else {
                return false;
            }
        }
        for (Integer value : dictionary.values()) {
            if(value!=0)
                return false;
        }
        return true;
    }
}
