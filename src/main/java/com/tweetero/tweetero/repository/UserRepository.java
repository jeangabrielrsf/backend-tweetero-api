package com.tweetero.tweetero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetero.tweetero.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    
}
