package com.project.interview_generate.web.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.interview_generate.domain.question.model.Category;
import com.project.interview_generate.infra.email.QuestionMailSendService;

@RestController
@RequestMapping("/api/test/mail")
@CrossOrigin(origins = "http://localhost:3000")
public class MailTestController {

	private final QuestionMailSendService mailSendService;

	public MailTestController(QuestionMailSendService mailSendService) {
		this.mailSendService = mailSendService;
	}

	@PostMapping
	public void send() {
		mailSendService.send();
	}

	@GetMapping
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("Call success!!");
	}

	// @PostMapping
	// public ResponseEntity<String> testPost(@RequestBody TestUserData userData) throws InterruptedException {
	// 	System.out.println("userData = " + userData);
	// 	Thread.sleep(3000L);
	// 	return ResponseEntity.ok("Call success!!");
	// }

	record TestUserData(String email, Category category) {

	}
}
