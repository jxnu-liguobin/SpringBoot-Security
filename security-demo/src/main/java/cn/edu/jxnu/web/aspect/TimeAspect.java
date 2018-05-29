package cn.edu.jxnu.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import lombok.extern.slf4j.Slf4j;

/**
 * 时间切面
 */
// @Aspect
// @Component
@Slf4j
public class TimeAspect {

	@Around("execution(* cn.edu.xjnu.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

		log.info("time aspect start");

		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			log.info("arg is " + arg);
		}

		long start = new Date().getTime();

		Object object = pjp.proceed();

		log.info("time aspect 耗时:" + (new Date().getTime() - start));

		log.info("time aspect end");

		return object;
	}

}
