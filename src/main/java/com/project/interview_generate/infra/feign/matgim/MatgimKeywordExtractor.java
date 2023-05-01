package com.project.interview_generate.infra.feign.matgim;

import org.springframework.stereotype.Component;

import com.project.interview_generate.domain.question.dto.ExtractedKeywordResponses;
import com.project.interview_generate.domain.question.dto.GeneratedQuestionResponses;
import com.project.interview_generate.domain.question.service.KeywordExtractor;
import com.project.interview_generate.infra.feign.matgim.dto.MatgimKeywordFeignRequest;
import com.project.interview_generate.infra.feign.matgim.dto.MatgimKeywordFeignResponse;

@Component
public class MatgimKeywordExtractor implements KeywordExtractor {

	public final MatgimClient matgimClient;

	public MatgimKeywordExtractor(MatgimClient matgimClient) {
		this.matgimClient = matgimClient;
	}

	@Override
	public ExtractedKeywordResponses extract(GeneratedQuestionResponses responses) {
		MatgimKeywordFeignResponse callResponse = matgimClient.call(
			new MatgimKeywordFeignRequest(responses.questions()));
		return callResponse.map();
	}
}
