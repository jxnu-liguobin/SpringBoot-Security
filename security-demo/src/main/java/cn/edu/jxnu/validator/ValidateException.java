package cn.edu.jxnu.validator;

import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * 验证异常
 * 
 * @author 梦境迷离.
 * @time 2018年5月29日
 * @version v1.0
 */
public class ValidateException extends RuntimeException {

	private static final long serialVersionUID = 7207451175263593487L;

	private List<ObjectError> errors;

	public ValidateException(List<ObjectError> errors) {
		this.errors = errors;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}

}
