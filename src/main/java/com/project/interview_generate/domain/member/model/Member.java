package com.project.interview_generate.domain.member.model;

import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.domain.type.model.Email;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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

	@Embedded
	private Email email;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Category category;

	protected Member() {
	}

	public Member(Email email, Category category) {
		this.email = email;
		this.category = category;
	}

	public Long id() {
		return id;
	}

	public Email email() {
		return email;
	}

	public Category category() {
		return category;
	}
}
