package com.project.interview_generate.infra.feign.openai.dto;

import java.util.List;

public record OpenAIQuestionFeignResponse(
	List<Message> choices
) {
	public String getContent() {
		return choices.get(0)
			.message()
			.content();
	}

	public record Content(
		String content
	) {
	}

	public record Message(
		Content message
	) {
	}
}
