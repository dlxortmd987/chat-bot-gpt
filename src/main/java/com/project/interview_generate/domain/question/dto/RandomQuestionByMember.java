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

	private static final String TWO_LINE_SEPARATOR = System.lineSeparator() + System.lineSeparator();
	private static final String MESSAGE_HEAD = "오늘의 질문입니다.%sCategory: %s";

	public static RandomQuestionByMember from(Member member, List<Question> questions) {
		List<String> queries = questions.stream()
			.map(Question::query)
			.toList();
		return new RandomQuestionByMember(member.category(), member.email().value(), queries);
	}

	public String concatQuestions() {
		return MESSAGE_HEAD.formatted(TWO_LINE_SEPARATOR, category)
			+ TWO_LINE_SEPARATOR
			+ String.join(TWO_LINE_SEPARATOR, questions);
	}
}
