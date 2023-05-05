package com.project.interview_generate.domain.question.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Keyword {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String value;

	protected Keyword() {
	}

	public Keyword(String value) {
		this.value = value;
	}

	public Long id() {
		return id;
	}

	public String value() {
		return value;
	}
}
