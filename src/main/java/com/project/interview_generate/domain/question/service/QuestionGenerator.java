package com.project.interview_generate.domain.question.service;

import java.util.List;

import com.project.interview_generate.domain.question.dto.ExtractedKeywordResponse;

public interface QuestionGenerator {

	List<ExtractedKeywordResponse> generate();
}
