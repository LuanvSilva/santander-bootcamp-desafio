package com.example.santander.santander.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.santander.santander.domain.model.User;
import com.example.santander.santander.service.UserService;

import lombok.var;

@RestController
@RequestMapping("/users")
public class UserController {
  
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.FindById(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {

        var userCreated = this.userService.create(user);
        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(userCreated.getId())
                        .toUri();

        return ResponseEntity.created(location).body(userCreated);
    }


}
