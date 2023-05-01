package com.project.interview_generate.infra.feign.matgim.dto;

import java.util.List;

import com.project.interview_generate.domain.question.dto.ExtractedKeywordResponses;

public record MatgimKeywordFeignResponse(
	List<SentenceResponse> sentences
) {
	public ExtractedKeywordResponses map() {
		return new ExtractedKeywordResponses(this.sentences()
			.stream()
			.map(SentenceResponse::map)
			.toList());
	}

	public record KeywordResponse(
		String word
	) {
		private static List<String> toWords(List<KeywordResponse> keywordResponses) {
			return keywordResponses.stream()
				.map(KeywordResponse::word)
				.toList();
		}
	}

	public record SentenceResponse(
		String sentence,
		List<KeywordResponse> keywords
	) {
		private ExtractedKeywordResponses.ExtractedKeywordResponse map() {
			return new ExtractedKeywordResponses.ExtractedKeywordResponse(sentence, KeywordResponse.toWords(keywords));
		}
	}
}
