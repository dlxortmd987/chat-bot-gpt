package com.project.interview_generate.infra.feign.openai.dto;

import java.util.List;

import com.project.interview_generate.domain.question.model.Category;

public record OpenAIQuestionRequest(
	String model,
	List<MessageContent> messages
) {

	private static final String QUESTION_MODEL = "gpt-3.5-turbo";

	private OpenAIQuestionRequest(String content) {
		this(QUESTION_MODEL, List.of(new MessageContent("user", content)));
	}

	public static OpenAIQuestionRequest fromCategory(Category category) {
		return new OpenAIQuestionRequest("%s 관련 개발자 면접 질문 3개 알려줘".formatted(category.name()));
	}

	public record MessageContent(
		String role,
		String content
	) {
	}
}
