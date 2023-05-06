package com.project.interview_generate.infra.email;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.project.interview_generate.domain.question.dto.RandomQuestionByMember;
import com.project.interview_generate.domain.question.service.QuestionFindService;
import com.project.interview_generate.domain.question.service.QuestionSendService;

@Component
public class QuestionMailSendService implements QuestionSendService {

	public static final String SUBJECT = "[Daily Interview]";
	private final QuestionFindService questionFindService;
	private final JavaMailSender mailSender;

	public QuestionMailSendService(QuestionFindService questionFindService, JavaMailSender mailSender) {
		this.questionFindService = questionFindService;
		this.mailSender = mailSender;
	}

	@Override
	public void send() {
		List<RandomQuestionByMember> randomQuestions = questionFindService.findRandomQuestions();
		randomQuestions.forEach(this::send);
	}

	private void send(RandomQuestionByMember question) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(question.email());
		message.setSubject(SUBJECT);
		message.setText(question.concatQuestions());

		mailSender.send(message);
	}
}
