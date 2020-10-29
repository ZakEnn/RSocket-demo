package com.rsocket.demo.domain;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Tweet {
	private String id;
	private String author;
	private String body;
	private LocalDate date;

	public static Tweet instanceOf(String author, String body) {
		return new Tweet(UUID.randomUUID().toString(), author, body, getRandomDate());
	}

	private static LocalDate getRandomDate() {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		return LocalDate.of(tlr.nextInt(1999, 2020), tlr.nextInt(1, 12), tlr.nextInt(1, 31));
	}
}
