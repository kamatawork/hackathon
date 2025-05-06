package com.hackathon.hackathon.service;

import com.hackathon.hackathon.entity.UserEntity;
import com.hackathon.hackathon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity authenticate(String userId, String password) {
        System.out.println("UserService userId:" + userId);
        return userRepository.findByUserId(userId)
                .filter(user -> user.getPassword().equals(password))
                .orElse(null);
    }
}
