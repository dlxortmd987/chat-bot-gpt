package com.project.interview_generate.domain.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.interview_generate.domain.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
