package com.project.interview_generate.domain.question.dto;

import java.util.List;

public record ExtractedKeywordResponse(
	String category,
	List<QuestionKeywordResponse> questions
) {
	public record QuestionKeywordResponse(
		String question,
		List<String> keywords
	) {
	}
}
