package com.project.interview_generate.web.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.interview_generate.infra.email.QuestionMailSendService;

@RestController
@RequestMapping("/api/test/mail")
public class MailTestController {

	private final QuestionMailSendService mailSendService;

	public MailTestController(QuestionMailSendService mailSendService) {
		this.mailSendService = mailSendService;
	}

	@PostMapping
	public void send() {
		mailSendService.send();
	}
}
