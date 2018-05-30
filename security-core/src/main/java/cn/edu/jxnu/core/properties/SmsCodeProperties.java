package cn.edu.jxnu.core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 短信验证码的属性参数
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Setter
@Getter
public class SmsCodeProperties {

	private int length = 6;
	private int expireIn = 60;

	private String url;

}
