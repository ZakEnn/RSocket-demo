package com.rsocket.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rsocket.demo.domain.Tweet;
import com.rsocket.demo.domain.TweetService;

import reactor.core.publisher.Flux;

@RestController
public class TweetSocketController {
	@Autowired
	private TweetService tweetService;

	@GetMapping(value = "/tweets/{author}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tweet> getByAuthor(@PathVariable String author) {
		return tweetService.getByAuthor(author);
	}

}
