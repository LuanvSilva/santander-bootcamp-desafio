package com.example.santander.santander.service.impl;

import org.springframework.stereotype.Service;

import com.example.santander.santander.domain.model.User;
import com.example.santander.santander.repository.UserRepository;
import com.example.santander.santander.service.UserService;

@Service
public class UserServiceimpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User FindById(Long id) {

        return  this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User create(User user) {

        if(userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new RuntimeException("This Account Number already exists");
        }
        
        return this.userRepository.save(user);
    }
    
}
