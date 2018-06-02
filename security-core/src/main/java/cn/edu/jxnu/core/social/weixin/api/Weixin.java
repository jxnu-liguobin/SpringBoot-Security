package cn.edu.jxnu.core.social.weixin.api;

/**
 * 微信API调用接口
 * 
 * @author 梦境迷离.
 * @time 2018年6月2日
 * @version v1.0
 */
public interface Weixin {

	// 获取用户信息
	WeixinUserInfo getUserInfo(String openId);

}
