package com.project.interview_generate.infra.feign.openai;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import com.project.interview_generate.infra.feign.config.FeignTest;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionFeignResponse;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionRequest;

@ImportAutoConfiguration(OpenAIHeaderConfig.class)
@FeignTest
class OpenAIClientTest {

	private final Logger log = LoggerFactory.getLogger(OpenAIClientTest.class);

	@Autowired
	private OpenAIClient questionGenerator;

	@DisplayName("Open AI 를 통해 질문을 생성할 수 있다.")
	@Test
	void call() {
		// given
		OpenAIQuestionRequest request = OpenAIQuestionRequest.newInstance();

		// when
		OpenAIQuestionFeignResponse actual = questionGenerator.call(request);

		// then
		Assertions.assertThat(actual)
			.isNotNull();
		log.info("result: {}", actual);
	}
}