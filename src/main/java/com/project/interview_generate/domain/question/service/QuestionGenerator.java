package com.project.interview_generate.domain.question.service;

import java.util.List;

import com.project.interview_generate.domain.question.dto.GeneratedQuestion;

public interface QuestionGenerator {

	List<GeneratedQuestion> generate();
}
