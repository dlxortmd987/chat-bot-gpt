package com.project.interview_generate.infra.feign.matgim;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import com.project.interview_generate.infra.feign.config.FeignTest;
import com.project.interview_generate.infra.feign.matgim.dto.MatgimKeywordFeignRequest;
import com.project.interview_generate.infra.feign.matgim.dto.MatgimKeywordFeignResponse;

@ImportAutoConfiguration(MatgimHeaderConfig.class)
@FeignTest
class MatgimClientTest {

	private final Logger log = LoggerFactory.getLogger(MatgimClientTest.class);

	@Autowired
	private MatgimClient keywordExtractor;

	@DisplayName("외부 api 를 통해 키워드를 추출할 수 있다.")
	@Test
	void extract() {
		// given
		MatgimKeywordFeignRequest request = new MatgimKeywordFeignRequest("1. 데이터베이스 정규화란 무엇이며, 왜 필요한가요?");

		// when
		MatgimKeywordFeignResponse actual = keywordExtractor.call(request);

		// then
		Assertions.assertThat(actual)
			.isNotNull();
		log.info("result: {}", actual);
	}
}