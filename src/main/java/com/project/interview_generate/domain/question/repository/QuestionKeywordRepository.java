package com.project.interview_generate.domain.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.interview_generate.domain.question.model.QuestionKeyword;

public interface QuestionKeywordRepository extends JpaRepository<QuestionKeyword, Long> {
}
