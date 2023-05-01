package com.project.interview_generate.infra.feign.openai.dto;

import java.util.List;

public record OpenAIQuestionFeignResponse(
	List<ResponseMessage> choices
) {
	public String getQueries() {
		return choices.get(0)
			.message()
			.content();
	}

	public record ResponseMessageContent(
		String content
	) {
	}

	public record ResponseMessage(
		ResponseMessageContent message
	) {
	}
}
