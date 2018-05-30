package cn.edu.jxnu.core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 分离，获取验证码类型，可重用设计
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Setter
@Getter
public class ValidateCodeProperties {

	private ImageCodeProperties image = new ImageCodeProperties();

	private SmsCodeProperties sms = new SmsCodeProperties();

}
