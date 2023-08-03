package com.ajay.practice.service;


import org.springframework.stereotype.Service;

@Service
public class MaxWaterService {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int area = 0;
        while(r>l){
            area = Math.max(Math.min(height[l],height[r])*(r-l),area);
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return area;
    }
}
