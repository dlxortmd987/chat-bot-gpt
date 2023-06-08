package com.project.interview_generate.domain.member.model;

import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.domain.type.model.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MemberSubscribeRequest(

	@NotBlank
	String email,

	@NotNull
	Category category
) {

	public Member toEntity() {
		return new Member(new Email(email), category);
	}
}
