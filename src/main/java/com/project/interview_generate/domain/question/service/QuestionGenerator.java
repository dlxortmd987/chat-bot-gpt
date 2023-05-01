package com.project.interview_generate.domain.question.service;

import com.project.interview_generate.domain.question.dto.GeneratedQuestionResponses;
import com.project.interview_generate.domain.question.model.Category;

public interface QuestionGenerator {

	GeneratedQuestionResponses generate(Category category);
}
