package com.project.interview_generate.domain.question.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.interview_generate.domain.question.dto.GeneratedQuestion;
import com.project.interview_generate.domain.question.model.Keyword;
import com.project.interview_generate.domain.question.model.Question;
import com.project.interview_generate.domain.question.model.QuestionKeyword;
import com.project.interview_generate.domain.question.repository.KeywordRepository;
import com.project.interview_generate.domain.question.repository.QuestionKeywordRepository;
import com.project.interview_generate.domain.question.repository.QuestionRepository;

@Service
public class QuestionFacadeService {

	private final QuestionRepository questionRepository;
	private final QuestionKeywordRepository questionKeywordRepository;
	private final KeywordRepository keywordRepository;

	public QuestionFacadeService(
		QuestionRepository questionRepository,
		QuestionKeywordRepository questionKeywordRepository,
		KeywordRepository keywordRepository
	) {
		this.questionRepository = questionRepository;
		this.questionKeywordRepository = questionKeywordRepository;
		this.keywordRepository = keywordRepository;
	}

	@Transactional
	public void saveQuestions(List<GeneratedQuestion> questions) {
		List<Question> newQuestions = new ArrayList<>();
		List<Keyword> newKeywords = new ArrayList<>();
		List<QuestionKeyword> newQuestionKeywords = new ArrayList<>();

		questions.forEach(question -> {
			Question newQuestion = question.toQuestion();
			newQuestions.add(newQuestion);

			List<Keyword> newSomeKeywords = question.toKeywords();
			newKeywords.addAll(newSomeKeywords);

			newQuestionKeywords.addAll(newSomeKeywords.stream()
				.map(keyword -> new QuestionKeyword(newQuestion, keyword))
				.toList());
		});

		questionRepository.saveAll(newQuestions);
		keywordRepository.saveAll(newKeywords);
		questionKeywordRepository.saveAll(newQuestionKeywords);
	}
}
