package com.example.santander.santander.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.santander.santander.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
     
    boolean existsByAccountNumber(String accountNumber);
}
