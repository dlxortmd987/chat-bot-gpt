package com.project.interview_generate.domain.type.model;

import java.util.regex.Pattern;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
public class Email {

	private String value;

	@Transient
	private static Pattern emailPattern = Pattern.compile(
		"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

	protected Email() {
	}

	public Email(String email) {
		checkValid(email);
	}

	private void checkValid(String email) {
		if (email == null) {
			throw new NullPointerException("email is null");
		}

		if (!emailPattern.matcher(email).find()) {
			throw new RuntimeException("email 형식이 잘못되었습니다.");
		}
	}

	public String value() {
		return value;
	}
}
