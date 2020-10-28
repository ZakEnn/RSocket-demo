package com.rsocket.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rsocket.demo.domain.Tweet;
import com.rsocket.demo.domain.TweetService;

import reactor.core.publisher.Flux;

@Controller
public class TweetSocketController {
	private final TweetService tweetService;

	public TweetSocketController(TweetService tweetService) {
		this.tweetService = tweetService;
	}

	@GetMapping(value = "/tweets/{author}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tweet> getByAuthor(@PathVariable String author) {
		return tweetService.getByAuthor(author);
	}

}
