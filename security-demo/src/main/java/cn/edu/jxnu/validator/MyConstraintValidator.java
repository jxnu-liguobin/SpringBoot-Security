package cn.edu.jxnu.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.jxnu.service.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义注解处理
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@Slf4j
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	@Autowired
	private HelloService helloService;

	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		log.info("my validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		helloService.greeting("tom");
		log.info(value.toString());
		return true;
	}

}
