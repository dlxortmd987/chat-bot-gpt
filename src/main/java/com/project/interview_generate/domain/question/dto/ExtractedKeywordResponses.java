package com.project.interview_generate.domain.question.dto;

import java.util.List;

public record ExtractedKeywordResponses(
	List<ExtractedKeywordResponse> responses
) {
	public record ExtractedKeywordResponse(
		String question,
		List<String> keywords
	) {
	}
}
