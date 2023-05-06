package com.project.interview_generate.domain.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.domain.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query(value = """
			SELECT *
			  FROM interview.question
			  WHERE category = :#{#category.name()}
			  ORDER BY RAND()
			  LIMIT :limit
		""", nativeQuery = true)
	List<Question> findRandom(

		@Param("category")
		Category category,

		@Param("limit")
		int limit
	);
}
