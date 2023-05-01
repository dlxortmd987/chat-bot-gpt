package com.project.interview_generate.infra.feign.openai;

import org.springframework.stereotype.Component;

import com.project.interview_generate.domain.question.dto.GeneratedQuestionResponses;
import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.domain.question.service.QuestionGenerator;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionFeignResponse;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionRequest;

@Component
public class OpenAIQuestionGenerator implements QuestionGenerator {

	private final OpenAIClient openAIClient;

	public OpenAIQuestionGenerator(OpenAIClient openAIClient) {
		this.openAIClient = openAIClient;
	}

	@Override
	public GeneratedQuestionResponses generate(Category category) {
		OpenAIQuestionFeignResponse feignResponse = openAIClient.call(OpenAIQuestionRequest.fromCategory(category));
		return new GeneratedQuestionResponses(feignResponse.getQueries());
	}
}
