package com.project.interview_generate.domain.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.interview_generate.domain.question.model.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
