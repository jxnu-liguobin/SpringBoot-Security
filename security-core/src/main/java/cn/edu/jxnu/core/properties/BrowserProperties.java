package cn.edu.jxnu.core.properties;

import lombok.Data;

/**
 * 浏览器特有参数属性配置
 * 
 * @author 梦境迷离.
 * @time 2018年5月30日
 * @version v1.0
 */
@Data
public class BrowserProperties {

	private SessionProperties session = new SessionProperties();

	/**
	 * 默认注册页面，由browser模块限定
	 */
	private String signUpUrl = "/imooc-signUp.html";

	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

	private LoginResponseType loginType = LoginResponseType.JSON;

	private int rememberMeSeconds = 3600;

}
