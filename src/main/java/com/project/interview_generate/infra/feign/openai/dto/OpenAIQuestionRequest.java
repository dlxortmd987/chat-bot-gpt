package com.project.interview_generate.infra.feign.openai.dto;

import java.util.List;

public record OpenAIQuestionRequest(
	String model,
	List<MessageContent> messages
) {

	private static final String QUESTION_MODEL = "gpt-3.5-turbo";

	public OpenAIQuestionRequest(String content) {
		this(QUESTION_MODEL, List.of(new MessageContent("user", content)));
	}

	public record MessageContent(
		String role,
		String content
	) {
	}
}
