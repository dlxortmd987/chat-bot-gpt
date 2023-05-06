package com.project.interview_generate.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.interview_generate.domain.member.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
