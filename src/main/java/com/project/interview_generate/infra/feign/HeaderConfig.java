package com.project.interview_generate.infra.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class HeaderConfig {

	@Bean
	public RequestInterceptor requestInterceptor(
		@Value("${openai.key}")
		String key
	) {
		return requestTemplate -> requestTemplate.header("Authorization", key);
	}
}
