package com.project.interview_generate.domain.question.dto;

import java.util.List;

import com.project.interview_generate.domain.member.model.Member;
import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.domain.question.model.Question;

public record RandomQuestionByMember(
	Category category,
	String email,
	List<String> questions
) {
	public static RandomQuestionByMember from(Member member, List<Question> questions) {
		List<String> queries = questions.stream()
			.map(Question::query)
			.toList();
		return new RandomQuestionByMember(member.category(), member.email(), queries);
	}

	public String concatQuestions() {
		return String.join("\n\n", questions);
	}
}
