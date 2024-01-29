package com.tweetero.tweetero.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.tweetero.dto.UserDTO;
import com.tweetero.tweetero.models.UserModel;
import com.tweetero.tweetero.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO body ) {
        Optional<UserModel> newUser = userService.saveUser(body);
        if (!newUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username já escolhido por outro usuário!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
