package com.project.interview_generate.infra.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLogger {
	private final Logger log = LoggerFactory.getLogger(TimeLogger.class);

	@Pointcut("@annotation(com.project.interview_generate.infra.annotation.LogTime)")
	private void setLog() {

	}

	@Around("setLog()")
	public void logTime(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		String methodName = signature.getMethod().getName();

		log.info("{} 실행 전 시간: {}", methodName, LocalDateTime.now());
		joinPoint.proceed();
		log.info("{} 실행 후 시간: {}", methodName, LocalDateTime.now());
	}
}
