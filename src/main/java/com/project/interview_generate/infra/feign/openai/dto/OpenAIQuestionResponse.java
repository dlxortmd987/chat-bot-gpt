package com.project.interview_generate.infra.feign.openai.dto;

import java.util.List;

public record OpenAIQuestionResponse(
	List<ResponseMessage> choices
) {
	public List<String> getQueries() {
		return choices.get(0)
			.message()
			.getQueries();
	}

	public record ResponseMessageContent(
		String content
	) {

		private List<String> getQueries() {
			return List.of(content.split("\n"));
		}

	}

	public record ResponseMessage(
		ResponseMessageContent message
	) {
	}
}
