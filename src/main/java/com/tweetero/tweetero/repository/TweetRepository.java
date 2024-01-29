package com.tweetero.tweetero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetero.tweetero.models.TweetModel;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long>{
    
}
