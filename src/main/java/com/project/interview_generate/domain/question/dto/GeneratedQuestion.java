package com.project.interview_generate.domain.question.dto;

import java.util.List;

import com.project.interview_generate.domain.question.model.Category;

public record GeneratedQuestion(
	Category category,
	String query,
	List<String> keywords
) {
}
