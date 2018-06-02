package cn.edu.jxnu.core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * spring social的属性参数
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Setter
@Getter
public class SocialProperties {

	// 默认是auth/qq，可配置的请求路径
	private String filterProcessesUrl = "/auth";

	private QQProperties qq = new QQProperties();

	// 把微信属性添加进来
	private WeixinProperties weixin = new WeixinProperties();

}
