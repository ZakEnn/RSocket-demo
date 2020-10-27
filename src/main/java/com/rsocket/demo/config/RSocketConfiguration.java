package com.rsocket.demo.config;

import java.net.URI;

import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;

import reactor.core.publisher.Mono;

@Configuration
public class RSocketConfiguration {

	@LocalServerPort
	private int port;

	private RSocketRequester.Builder rsocketRequester;

	@Bean
	public Mono<RSocketRequester> rSocketRequester(RSocketStrategies rSocketStrategies,
			RSocketProperties rSocketProps) {
		return rsocketRequester.rsocketStrategies(rSocketStrategies).connectWebSocket(getURI(rSocketProps));

	}

	private URI getURI(RSocketProperties rSocketProps) {
		return URI.create(String.format("ws://localhost:%d%s", port, rSocketProps.getServer().getMappingPath()));
	}

}
