package com.project.interview_generate.infra.feign.openai;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionFeignResponse;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionRequest;

@FeignClient(name = "OpenAIQuestion", url = "${openai.url}", configuration = OpenAIHeaderConfig.class)
public interface OpenAIClient {

	@PostMapping
	OpenAIQuestionFeignResponse call(
		@RequestBody OpenAIQuestionRequest request
	);
}
