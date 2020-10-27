package com.rsocket.demo.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Tweet {
	private String id;
	private String author;
	private String body;
	private LocalDate date;

}
