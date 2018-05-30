package cn.edu.jxnu.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * QQ参数属性配置
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Setter
@Getter
public class QQProperties extends SocialProperties {

	private String providerId = "qq";

}
