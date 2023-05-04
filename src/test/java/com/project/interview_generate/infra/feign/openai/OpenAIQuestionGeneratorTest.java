package com.project.interview_generate.infra.feign.openai;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import com.project.interview_generate.domain.question.dto.GeneratedQuestion;
import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionFeignResponse;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionRequest;

@ExtendWith(MockitoExtension.class)
@ImportAutoConfiguration(OpenAIQuestionGenerator.class)
class OpenAIQuestionGeneratorTest {

	private static final OpenAIQuestionFeignResponse FEIGN_RESPONSE = getResponse();

	@Mock
	private OpenAIClient openAIClient;

	@InjectMocks
	private OpenAIQuestionGenerator questionGenerator;

	private static OpenAIQuestionFeignResponse getResponse() {
		String mockContent = """
			[
			  {
			       "category": "DB",
			       "query": "DB 정규화란?",
			       "keywords": ["정규화", "데이터베이스"]
			     },
			     {
			       "category": "NETWORK",
			       "query": "HTTP와 HTTPS 차이점은?",
			       "keywords": ["HTTP", "HTTPS", "네트워크"]
			     }
			]
			""";
		OpenAIQuestionFeignResponse.Content content = new OpenAIQuestionFeignResponse.Content(mockContent);
		return new OpenAIQuestionFeignResponse(List.of(new OpenAIQuestionFeignResponse.Message(content)));
	}

	@Test
	void generate() {
		// given
		BDDMockito.when(openAIClient.call(OpenAIQuestionRequest.newInstance()))
			.thenReturn(FEIGN_RESPONSE);

		List<GeneratedQuestion> expect = List.of(
			new GeneratedQuestion(
				Category.DB,
				"DB 정규화란?",
				List.of("정규화", "데이터베이스")),
			new GeneratedQuestion(
				Category.NETWORK,
				"HTTP와 HTTPS 차이점은?",
				List.of("HTTP", "HTTPS", "네트워크")));

		// when
		List<GeneratedQuestion> actual = questionGenerator.generate();

		// then
		Assertions.assertThat(actual)
			.isEqualTo(expect);
	}
}