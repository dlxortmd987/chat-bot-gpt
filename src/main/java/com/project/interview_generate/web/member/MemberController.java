package com.project.interview_generate.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.interview_generate.domain.member.model.Member;
import com.project.interview_generate.domain.member.model.MemberSubscribeRequest;
import com.project.interview_generate.domain.member.repository.MemberRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

	private final MemberRepository memberRepository;

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	public MemberController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@PostMapping
	public ResponseEntity<Void> subscribe(@Valid @RequestBody MemberSubscribeRequest memberSubscribeRequest) {
		log.info("response data: {}", memberSubscribeRequest);
		Member save = memberRepository.save(memberSubscribeRequest.toEntity());

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
