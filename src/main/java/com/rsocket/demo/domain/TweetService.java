package com.rsocket.demo.domain;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class TweetService {
	private static final Map<String, Tweet> tweets = new HashMap<String, Tweet>() {
		{
			put("zak", Tweet.instanceOf("zak", "okbye"));
			put("med", Tweet.instanceOf("med", "hello"));
		}
	};

	public Flux<Tweet> getByAuthor(String author) {
		return Flux.fromStream(new Random().ints(10).mapToObj(value -> tweets.get(author)))
				.delayElements(Duration.ofSeconds(1));
	}

}
