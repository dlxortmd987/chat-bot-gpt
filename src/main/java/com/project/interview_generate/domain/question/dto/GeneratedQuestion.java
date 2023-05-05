package com.project.interview_generate.domain.question.dto;

import java.util.List;

import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.domain.question.model.Keyword;
import com.project.interview_generate.domain.question.model.Question;

public record GeneratedQuestion(
	Category category,
	String query,
	List<String> keywords
) {

	public List<Keyword> toKeywords() {
		return keywords.stream()
			.map(Keyword::new)
			.toList();
	}

	public Question toQuestion() {
		return new Question(query, category);
	}

}
