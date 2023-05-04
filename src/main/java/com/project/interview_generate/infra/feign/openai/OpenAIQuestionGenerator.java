package com.project.interview_generate.infra.feign.openai;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.interview_generate.domain.question.dto.GeneratedQuestion;
import com.project.interview_generate.domain.question.service.QuestionGenerator;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionFeignResponse;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionRequest;

@Component
public class OpenAIQuestionGenerator implements QuestionGenerator {

	private final OpenAIClient openAIClient;
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public OpenAIQuestionGenerator(OpenAIClient openAIClient) {
		this.openAIClient = openAIClient;
	}

	@Override
	public List<GeneratedQuestion> generate() {
		OpenAIQuestionFeignResponse feignResponse = openAIClient.call(OpenAIQuestionRequest.newInstance());

		try {
			return objectMapper.readValue(feignResponse.getContent(), new TypeReference<>() {
			});
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
}
