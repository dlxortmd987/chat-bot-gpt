package com.project.interview_generate.infra.feign.openai;

import java.io.IOException;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import com.project.interview_generate.domain.question.dto.GeneratedQuestion;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionFeignResponse;
import com.project.interview_generate.infra.feign.openai.dto.OpenAIQuestionRequest;

@ExtendWith(MockitoExtension.class)
@ImportAutoConfiguration(OpenAIQuestionGenerator.class)
class OpenAIQuestionGeneratorTest {

	private final Logger log = LoggerFactory.getLogger(OpenAIQuestionGeneratorTest.class);

	private static OpenAIQuestionFeignResponse feignResponse = getResponse();

	@Mock
	private OpenAIClient openAIClient;

	@InjectMocks
	private OpenAIQuestionGenerator questionGenerator;

	private static OpenAIQuestionFeignResponse getResponse() {
		String mockContent = """
			[
			  {
			    \"category\": \"DB\",
			    \"questions\": [
			      {
			        \"question\": \"데이터베이스 성능 최적화를 위해 어떤 방법이 있나요?\",
			        \"keywords\": [\"성능\", \"최적화\"]
			      }
			    ]
			  },
			  {
			    \"category\": \"NETWORK\",
			    \"questions\": [
			      {
			        \"question\": \"TCP와 UDP의 차이점은 무엇인가요?\",
			        \"keywords\": [\"TCP\", \"UDP\"]
			      }
			    ]
			  }
			]
			""";
		OpenAIQuestionFeignResponse.Content content = new OpenAIQuestionFeignResponse.Content(mockContent);
		return new OpenAIQuestionFeignResponse(List.of(new OpenAIQuestionFeignResponse.Message(content)));
	}

	@Test
	void generate() throws IOException {
		// given
		BDDMockito.when(openAIClient.call(OpenAIQuestionRequest.newInstance()))
			.thenReturn(feignResponse);

		List<GeneratedQuestion> expect = List.of(
			new GeneratedQuestion("DB",
				List.of(
					new GeneratedQuestion.QuestionKeywordResponse("데이터베이스 성능 최적화를 위해 어떤 방법이 있나요?",
						List.of("성능", "최적화")))),
			new GeneratedQuestion("NETWORK",
				List.of(
					new GeneratedQuestion.QuestionKeywordResponse("TCP와 UDP의 차이점은 무엇인가요?",
						List.of("TCP", "UDP")))));

		// when
		List<GeneratedQuestion> actual = questionGenerator.generate();

		// then
		Assertions.assertThat(actual)
			.isEqualTo(expect);
	}
}