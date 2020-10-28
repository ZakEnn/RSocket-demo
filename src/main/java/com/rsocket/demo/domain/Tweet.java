package com.rsocket.demo.domain;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tweet {
	private String id;
	private String author;
	private String body;
	private LocalDate date;

	public static Tweet instanceOf(String author, String body) {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		return new Tweet(UUID.randomUUID().toString(), author, body,
				LocalDate.of(tlr.nextInt(1999, 2020), tlr.nextInt(1, 12), tlr.nextInt(1, 31)));
	}
}
