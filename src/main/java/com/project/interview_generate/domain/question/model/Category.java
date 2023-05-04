package com.project.interview_generate.domain.question.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Category {

	DB,
	NETWORK,
	OS,
	DATA_STRUCTURE,
	ALGORITHM,
	JAVA,
	SPRING,
	SPRING_JPA;

	public static String collectByString() {
		return Arrays.stream(values())
			.map(Enum::name)
			.collect(Collectors.joining(", "));
	}
}
