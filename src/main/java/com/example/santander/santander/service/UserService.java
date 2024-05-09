package com.example.santander.santander.service;

import com.example.santander.santander.domain.model.User;

public interface UserService {
    
    User FindById(Long id);

    User create(User user);
}
