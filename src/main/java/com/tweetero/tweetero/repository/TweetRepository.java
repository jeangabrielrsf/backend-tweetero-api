package com.tweetero.tweetero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetero.tweetero.models.TweetModel;

@Repository
public interface TweetRepository extends JpaRepository<TweetModel, Long>{
    List<TweetModel> findAllByUserId(Long id);
}
