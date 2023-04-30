package com.project.interview_generate.infra.feign.openai;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.interview_generate.domain.question.service.QuestionGenerator;
import com.project.interview_generate.infra.feign.HeaderConfig;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionRequest;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionResponse;

@FeignClient(name = "OpenAIQuestion", url = "${openai.url}", configuration = HeaderConfig.class)
public interface OpenAIQuestionGenerator extends QuestionGenerator {

	@PostMapping
	OpenAIQuestionResponse question(
		@RequestBody OpenAIQuestionRequest request
	);
}
