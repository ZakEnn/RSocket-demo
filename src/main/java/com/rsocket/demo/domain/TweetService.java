package com.rsocket.demo.domain;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.apachecommons.CommonsLog;
import reactor.core.publisher.Flux;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
@CommonsLog
public class TweetService {
	private Twitter twitter = getTweeterInstance();

	public Flux<Tweet> getByAuthor(String author) {
		return Flux.interval(Duration.ZERO, Duration.ofSeconds(1))
				.map(value -> Tweet.instanceOf(author, searchtweets(author)));
	}

	public List<String> searchtweets(String body) {
		Query query = new Query("source:twitter4j " + body);
		try {
			QueryResult result = twitter.search(query);
			return result.getTweets().stream().map(Status::getText).collect(Collectors.toList());
		} catch (TwitterException e) {
			log.warn(e.getMessage());
			return Collections.emptyList();
		}
	}

	public Twitter getTweeterInstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("key").setOAuthConsumerSecret("secret")
				.setOAuthAccessToken("token").setOAuthAccessTokenSecret("token_secret");
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();
	}

	public Tweet sendMessage(Tweet request) {
		log.info("Received request-response request: " + request);
		List<String> quotes = new ArrayList<>();
		quotes.add("dry");
		quotes.add("kiss");
		quotes.add("yagni");
		return Tweet.instanceOf("uncle bob", quotes);
	}

}
