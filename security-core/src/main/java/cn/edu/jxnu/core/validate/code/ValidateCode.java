package cn.edu.jxnu.core.validate.code;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * 验证码基类
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Setter
@Getter
public class ValidateCode {

	private String code;

	// 过期时间
	private LocalDateTime expireTime;

	public ValidateCode(String code, int expireIn) {
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}

	public ValidateCode(String code, LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}

	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}

}
