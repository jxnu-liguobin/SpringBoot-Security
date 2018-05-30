package cn.edu.jxnu.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义验证码异常
 * 
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
public class ValidateCodeException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7285211528095468156L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
