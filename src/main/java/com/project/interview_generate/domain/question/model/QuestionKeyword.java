package com.project.interview_generate.domain.question.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class QuestionKeyword {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question")
	private Question question;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "keyword")
	private Keyword keyword;

	protected QuestionKeyword() {
	}

	public QuestionKeyword(Question question, Keyword keyword) {
		this.question = question;
		this.keyword = keyword;
	}

	public Long id() {
		return id;
	}

	public Question question() {
		return question;
	}

	public Keyword keyword() {
		return keyword;
	}
}
