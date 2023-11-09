package com.ajay.practice.services.Impl;

import com.ajay.practice.model.User;
import com.ajay.practice.services.UserService;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Map<String, User> userRepository = new HashMap<>();
    @Override
    public User createUser(User user) {
        if(StringUtil.isNullOrEmpty(user.getId())){
            throw new RuntimeException("invalid UserId");
        }else if(userRepository.containsKey(user.getId())){
            throw new RuntimeException("user already exists");
        }
        userRepository.put(user.getId(), user);
        return user;
    }

    @Override
    public User getUser(String userId) {
        if(userRepository.containsKey(userId)){
            return userRepository.get(userId);
        }
        throw new RuntimeException("user not found");
    }
}
