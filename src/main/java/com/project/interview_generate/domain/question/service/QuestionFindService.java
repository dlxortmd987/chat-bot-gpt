package com.project.interview_generate.domain.question.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.interview_generate.domain.member.model.Member;
import com.project.interview_generate.domain.member.repository.MemberRepository;
import com.project.interview_generate.domain.question.dto.RandomQuestionByMember;
import com.project.interview_generate.domain.question.repository.QuestionRepository;

@Service
public class QuestionFindService {

	private final MemberRepository memberRepository;
	private final QuestionRepository questionRepository;

	public QuestionFindService(MemberRepository memberRepository, QuestionRepository questionRepository) {
		this.memberRepository = memberRepository;
		this.questionRepository = questionRepository;
	}

	public List<RandomQuestionByMember> findRandomQuestions() {
		List<Member> entireMembers = memberRepository.findAll();
		List<RandomQuestionByMember> result = new ArrayList<>();
		for (Member member : entireMembers) {
			result.add(RandomQuestionByMember.from(member, questionRepository.findRandom(member.category(), 3)));
		}
		return Collections.unmodifiableList(result);
	}
}
