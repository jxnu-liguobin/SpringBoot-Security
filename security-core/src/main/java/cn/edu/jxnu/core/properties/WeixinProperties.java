package cn.edu.jxnu.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信的属性参数
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Setter
@Getter
public class WeixinProperties extends SocialProperties {

	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
	 */
	private String providerId = "weixin";

}
