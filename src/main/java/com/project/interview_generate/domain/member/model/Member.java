package com.project.interview_generate.domain.member.model;

import com.project.interview_generate.domain.question.model.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Category category;

	protected Member() {
	}

	public Long id() {
		return id;
	}

	public String email() {
		return email;
	}

	public Category category() {
		return category;
	}
}
