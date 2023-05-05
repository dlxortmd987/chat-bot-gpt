package com.project.interview_generate.domain.question.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.interview_generate.domain.question.dto.GeneratedQuestion;

@Component
public class QuestionLoader {

	private final QuestionGenerator questionGenerator;
	private final QuestionFacadeService questionFacadeService;

	public QuestionLoader(QuestionGenerator questionGenerator, QuestionFacadeService questionFacadeService) {
		this.questionGenerator = questionGenerator;
		this.questionFacadeService = questionFacadeService;
	}

	public void load() {
		List<GeneratedQuestion> questions = questionGenerator.generate();
		questionFacadeService.saveQuestions(questions);
	}
}
