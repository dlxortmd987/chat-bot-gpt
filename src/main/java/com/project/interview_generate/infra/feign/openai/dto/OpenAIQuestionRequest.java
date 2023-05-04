package com.project.interview_generate.infra.feign.openai.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.project.interview_generate.domain.question.model.Category;

public record OpenAIQuestionRequest(
	String model,
	List<MessageContent> messages
) {

	private static final String QUESTION_MODEL = "gpt-3.5-turbo";
	private static final String DEFAULT_JSON_FORM = """
			[ 
				\"Category\": \"Category Name\", 
				\"Questions\": 
				[
					{
						\"Question\": \"질문1\", 
						\"Keywords\": 
						[
							"키워드1",
							"키워드2",
						]
					}, 
					{
						\"Question\": \"질문2\", 
						\"Keywords\": 
						[
							"키워드1",
							"키워드2",
						]
					}, 
				]
			]
		""".lines().collect(Collectors.joining()).replace("\t", "");

	private OpenAIQuestionRequest(String content) {
		this(QUESTION_MODEL, List.of(new MessageContent("user", content)));
	}

	public static OpenAIQuestionRequest newInstance() {
		// TODO: String 에서 객체의 serialize 로 변경
		return new OpenAIQuestionRequest(
			"%s 관련 개발자 면접 질문 3개씩 출력하는데 그 결과를 json 으로 줘. json form: %s".formatted(Category.collectByString(),
				DEFAULT_JSON_FORM));
	}

	public record MessageContent(
		String role,
		String content
	) {
	}
}
