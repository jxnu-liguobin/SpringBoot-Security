package cn.edu.jxnu.browser.support;

import lombok.Getter;
import lombok.Setter;

/**
 * 社交用户信息
 * 
 * 
 * @author 梦境迷离.
 * @time 2018年6月1日
 * @version v1.0
 */
@Setter
@Getter
public class SocialUserInfo {

	/** 标识是哪个第三方应用 . */
	private String providerId;

	private String providerUserId;

	private String nickname;

	private String headimg;

}
