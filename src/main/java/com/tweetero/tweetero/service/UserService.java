package com.tweetero.tweetero.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweetero.tweetero.dto.UserDTO;
import com.tweetero.tweetero.models.UserModel;
import com.tweetero.tweetero.repository.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;
    
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserModel> saveUser(UserDTO userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            return Optional.empty();
        }
        UserModel user = new UserModel(userDto);
        return Optional.of(userRepository.save(user));
    }

    public Optional<UserModel> findUserById (Long id) {
        return userRepository.findById(id);
    }

    
}
