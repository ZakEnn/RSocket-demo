package com.rsocket.demo.domain;

import java.time.Duration;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class TweetService {
	// private static final Map<String, Tweet> tweets = new HashMap<String, Tweet>()
	// {
	// {
	// put("zak", Tweet.instanceOf("zak", "okbye"));
	// put("med", Tweet.instanceOf("med", "hello"));
	// }
	// };

	public Flux<Tweet> getByAuthor(String author) {
		return Flux.interval(Duration.ZERO, Duration.ofSeconds(1)).map(i -> Tweet.instanceOf("zak", "okbye"));
	}
}
