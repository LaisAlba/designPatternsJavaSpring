package com.alba.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Aspect
@Component
public class AroundGetContactsAspect {

	@Pointcut("execution(* com.alba.service.BankService.*(..))")
	public void serviceMethod() {}

	/**
	 * In this case we wrap around the real method, controlling the input/output of that method, being a proxy.
	 * As a simple example we measure method execution time.
	 */
	@Around("serviceMethod()")
	public Object profile(ProceedingJoinPoint pjp) {
		LocalDateTime start = LocalDateTime.now();
		Object task = null;
		try {
			task = pjp.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		LocalDateTime end = LocalDateTime.now();
		Duration duration = Duration.between(start, end);
		System.out.println("Execution took: " + duration.toMillis() + " ms");
		return task;
	}

}
