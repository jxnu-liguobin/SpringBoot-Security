package cn.edu.jxnu.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 时间切面
 * 
 * 实现拦截Restful API的第三种方法
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@Aspect
@Component
@Slf4j
public class TimeAspect {

	/**
	 * 这种拿不到原始的request，response对象
	 * 
	 * Around 环绕，包括before after
	 * 
	 * @param pjp
	 * @return object
	 * @throws Throwable
	 *
	 */
	@Around("execution(* cn.edu.jxnu.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

		log.info("time aspect start");
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			log.info("arg is " + arg);
		}
		long start = new Date().getTime();
		Object object = pjp.proceed(); // 类似doFilter方法
		log.info("time aspect 耗时:" + (new Date().getTime() - start));
		log.info("time aspect end");
		return object;
	}

}
