package cn.edu.jxnu.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 自定义注解
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
