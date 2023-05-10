package com.project.interview_generate.domain.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.project.interview_generate.domain.question.service.QuestionLoader;
import com.project.interview_generate.domain.question.service.QuestionSendService;
import com.project.interview_generate.infra.annotation.LogTime;

@Component
public class Scheduler {

	private final QuestionLoader questionLoader;
	private final QuestionSendService questionSendService;

	public Scheduler(QuestionLoader questionLoader, QuestionSendService questionSendService) {
		this.questionLoader = questionLoader;
		this.questionSendService = questionSendService;
	}

	@LogTime
	@Scheduled(cron = "0 0 3 * * *")
	public void loadQuestions() throws InterruptedException {
		questionLoader.load();
	}

	@LogTime
	@Scheduled(cron = "0 0 9 * * *")
	public void sendQuestions() {
		questionSendService.send();
	}
}
