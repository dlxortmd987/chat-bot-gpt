package com.project.interview_generate.domain.question.service;

import com.project.interview_generate.domain.question.dto.ExtractedKeywordResponses;
import com.project.interview_generate.domain.question.dto.GeneratedQuestionResponses;

public interface KeywordExtractor {

	ExtractedKeywordResponses extract(GeneratedQuestionResponses responses);
}
