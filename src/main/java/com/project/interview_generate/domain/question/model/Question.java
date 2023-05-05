package com.project.interview_generate.domain.question.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String query;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;

	protected Question() {
	}

	public Question(String query, Category category) {
		this.query = query;
		this.category = category;
	}

	public Long id() {
		return id;
	}

	public String query() {
		return query;
	}

	public Category category() {
		return category;
	}
}
