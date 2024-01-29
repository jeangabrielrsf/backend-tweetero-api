package com.tweetero.tweetero.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.tweetero.dto.TweetDTO;
import com.tweetero.tweetero.models.TweetModel;
import com.tweetero.tweetero.service.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    final TweetService tweetService;
    TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping()
    public ResponseEntity<Object> getAllTweets() {
        List<TweetModel> tweets = tweetService.findAllTweets();
        return ResponseEntity.ok().body(tweets);
    }

    @PostMapping()
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body) {
        Optional<TweetModel> newTweet = tweetService.saveTweet(body);
        if (!newTweet.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newTweet);
    } 
}
