package com.tweetero.tweetero.service;

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

    public UserModel saveUser(UserDTO userDto) {
        UserModel user = new UserModel(userDto);
        return userRepository.save(user);
    }
    
}
