package com.project.interview_generate.domain.question.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.interview_generate.domain.question.dto.GeneratedQuestion;
import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.domain.question.repository.KeywordRepository;
import com.project.interview_generate.domain.question.repository.QuestionKeywordRepository;
import com.project.interview_generate.domain.question.repository.QuestionRepository;

@ImportAutoConfiguration(QuestionFacadeService.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuestionFacadeServiceTest {

	@Autowired
	private QuestionFacadeService questionFacadeService;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionKeywordRepository questionKeywordRepository;

	@Autowired
	private KeywordRepository keywordRepository;

	@Test
	void saveQuestions() {
		// given
		List<GeneratedQuestion> dummyInput = List.of(
			new GeneratedQuestion(
				Category.DB,
				"DB 정규화란?",
				List.of("정규화", "데이터베이스")),
			new GeneratedQuestion(
				Category.NETWORK,
				"HTTP와 HTTPS 차이점은?",
				List.of("HTTP", "HTTPS", "네트워크")));

		long beforeQuestionCount = questionRepository.count();
		long beforeQuestionKeywordCount = questionKeywordRepository.count();
		long beforeKeywordCount = keywordRepository.count();

		// when
		questionFacadeService.saveQuestions(dummyInput);

		// then
		long afterQuestionCount = questionRepository.count();
		long afterQuestionKeywordCount = questionKeywordRepository.count();
		long afterKeywordCount = keywordRepository.count();

		assertThat(afterQuestionCount - beforeQuestionCount)
			.isEqualTo(2);
		assertThat(afterQuestionKeywordCount - beforeQuestionKeywordCount)
			.isEqualTo(5);
		assertThat(afterKeywordCount - beforeKeywordCount)
			.isEqualTo(5);
	}
}