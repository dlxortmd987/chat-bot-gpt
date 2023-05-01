package com.project.interview_generate.infra.feign.matgim;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class MatgimHeaderConfig {

	@Bean
	public RequestInterceptor requestInterceptor(
		@Value("${matgim.key}")
		String key
	) {
		return requestTemplate -> requestTemplate.header("x-auth-token", key);
	}
}
