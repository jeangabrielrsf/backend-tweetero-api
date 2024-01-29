package com.tweetero.tweetero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweetero.tweetero.dto.TweetDTO;
import com.tweetero.tweetero.models.TweetModel;
import com.tweetero.tweetero.models.UserModel;
import com.tweetero.tweetero.repository.TweetRepository;
import com.tweetero.tweetero.repository.UserRepository;

@Service
public class TweetService {
    final TweetRepository tweetRepository;
    final UserRepository userRepository;

    TweetService (TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    
    public Optional<TweetModel> saveTweet(TweetDTO tweetDto) {
        Optional<UserModel> user = userRepository.findById(tweetDto.getUserId());
        if (user.isEmpty()) {
            return Optional.empty();
        }

        TweetModel tweet = new TweetModel();
        tweet.setText(tweetDto.getText());
        tweet.setUser(user.get());

        return Optional.of(tweetRepository.save(tweet));
    }

    public List<TweetModel> findAllTweets() {
        return tweetRepository.findAll();
    }

    public List<TweetModel> findAllTweetsByUserId(Long userId) {
        return tweetRepository.findAllByUserId(userId);
    }
}
