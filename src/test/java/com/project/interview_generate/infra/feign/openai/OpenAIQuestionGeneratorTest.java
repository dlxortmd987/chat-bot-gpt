package com.project.interview_generate.infra.feign.openai;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.interview_generate.infra.feign.config.FeignTest;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionRequest;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionResponse;

@FeignTest
class OpenAIQuestionGeneratorTest {

	private final Logger log = LoggerFactory.getLogger(OpenAIQuestionGeneratorTest.class);

	@Autowired
	private OpenAIQuestionGenerator questionGenerator;

	@DisplayName("Open AI 를 통해 질문을 생성할 수 있다.")
	@Test
	void question() {
		// given
		OpenAIQuestionRequest request = new OpenAIQuestionRequest("DB 관련 개발자 면접 질문 3개 알려줘.");

		// when
		OpenAIQuestionResponse actual = questionGenerator.question(request);

		// then
		Assertions.assertThat(actual)
			.isNotNull();
		Assertions.assertThat(actual.getQueries().size())
			.isEqualTo(3);
		log.info("result: {}", actual);
	}
}